package ru.vovan.diplomcompose.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import org.jsoup.Jsoup
import ru.vovan.diplomcompose.database.entity.Announcement
import ru.vovan.diplomcompose.database.entity.Audience
import ru.vovan.diplomcompose.database.entity.Lesson
import ru.vovan.diplomcompose.database.repository.AnnouncementRepository
import ru.vovan.diplomcompose.database.repository.AudienceRepository
import ru.vovan.diplomcompose.network.model.Post
import ru.vovan.diplomcompose.network.repository.PostRepository
import ru.vovan.diplomcompose.network.repository.TimetableRepository
import ru.vovan.diplomcompose.ui.model.CurrentAudienceObject
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class DataViewModel(
    private val postRepository: PostRepository,
    private val timetableRepository: TimetableRepository,
    private val audienceRepository: AudienceRepository,
    private val announcementRepository: AnnouncementRepository
): ViewModel() {
    init {
        viewModelScope.launch {
            browserAnnouncement()
            browserTimetable(CurrentAudienceObject.currentAudience)
        }
    }
    private fun getAllPosts() = postRepository.getAllPosts()
    private fun getAllTimetable(audienceNumber: String) = timetableRepository.getAllTimetable(audienceNumber)

    // Audience
    fun retrieveAudience() = audienceRepository.readAll()
    suspend fun readByIdAudience(id : String) = audienceRepository.read(id)
    fun readLessonByDate(date: String) = audienceRepository.readLessonByDate(date)

    // Announcement
    fun retrieveAnnouncement() = announcementRepository.readAll()
    fun browserAnnouncement(announcementsFlow: Flow<List<Post>> = getAllPosts()) {
        viewModelScope.launch{
            announcementsFlow.collect {
                if (it.isNotEmpty()) {
                    announcementRepository.deleteAll()
                    val currentDate: Date = Date()
                    val dateFormat: DateFormat = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
                    val dateText: String = dateFormat.format(currentDate)

                    it.forEach{item ->
                        announcementRepository.create(Announcement(text =  item.title, date = dateText))
                    }
                }
            }
        }
    }
    // Parse timetable
    fun browserTimetable(audienceNumber: String, strFlow : Flow<String> = getAllTimetable(audienceNumber)) {
        var strParse : String = ""
        try {
            viewModelScope.launch {
                strFlow.collect {
                    strParse = it
                }
                if (strParse.isNotEmpty())
                {
                    audienceRepository.deleteAllAudience()
                    audienceRepository.deleteAllLesson()
                    // Паттерны
                    val datePattern = "(0?[1-9]|[12][0-9]|3[01])[.](0?[1-9]|1[012])[.]([0-9][0-9][0-9][0-9])"
                    val numberOfLessonPattern = "[0-9]"
                    val itemTypePattern = "(Практика|Лабораторные работы|Лекции|Экзамен|Предэкзаменационные консультации)"
                    val groupPattern = "([А-ЯЁ]+[0-9]+[А-ЯЁ]+)"
                    val emailIconPattern = " ✉"
                    // Парсинг Jsoup
                    val doc = Jsoup.parse(strParse)
                    // Заголовки
                    val h3 = doc.getElementsByTag("h3")
                    val tables = doc.getElementsByTag("table")
                    // Объекты для Lesson
                    var regexDate : String
                    var regexNumberOfLesson : Int
                    var regexItemType : String
                    var regexItemName : String
                    var regexListGroup : String = ""
                    var regexLecture : String

                    for (i in 0 until h3.size)
                    {
                        // Регулярное выраженния для даты
                        val patternRegexDate = Regex(datePattern)
                        regexDate = patternRegexDate.find(h3[i].text())?.value ?: ""

                        // Все уроки на 1 день
                        val docTemp = Jsoup.parse(tables[i].toString())
                        val tr = docTemp.getElementsByTag("tr")
                        // Каждый урок по порядку
                        tr.forEach {trIt ->
                            val elementDiv = trIt.select("div")
                            val elementTd = trIt.select("td")

                            val tempNumberOfLesson = elementDiv.select("div").eq(1).text()
                            val tempItemLesson = elementDiv.select("div").eq(2).text()
                            val tempGroup = elementTd.select("td").eq(3).text()
                            val tempLecture = elementDiv.select("div").eq(4).text()

                            // Регулярное выраженния: НОМЕР ЗАНЯТИЯ
                            val patternRegexNumberOfLesson = Regex(numberOfLessonPattern)
                            regexNumberOfLesson = patternRegexNumberOfLesson.find(tempNumberOfLesson)?.value?.toInt() ?: 0

                            // Регулярное выраженния: ТИП ПРЕДМЕТА, НАЗВАНИЕ ПРЕДМЕТА
                            val patternItemType = Regex(itemTypePattern)
                            regexItemType = patternItemType.find(tempItemLesson)?.value ?: ""
                            regexItemName = tempItemLesson.subSequence(regexItemType.length + 3, tempItemLesson.length).toString()

                            // Регулярное выраженние: ГРУППЫ
                            val patternGroup = Regex(groupPattern)
                            val regexGroup = patternGroup.findAll(tempGroup)
                            regexGroup.forEach { it ->
                                regexListGroup += if (regexGroup.last().value == it.value) it.value else it.value + ", "
                            }
                            // Регулярное выраженния: ИМЯ ПРЕПОДАВАТЕЛЯ
                            val patternLecture = Regex(emailIconPattern)
                            regexLecture = patternLecture.replace(tempLecture, "")
                            // Добавление в базу данных УРОКА (в цикле - получается список)
                            audienceRepository.create(Lesson(
                                audienceId = audienceNumber,
                                numberOfLesson = regexNumberOfLesson,
                                itemName = regexItemName,
                                date = regexDate,
                                group = regexListGroup,
                                itemType = regexItemType,
                                lecturer = regexLecture
                            ))
                            regexListGroup = ""
                        }
                    }
                    val descriptorAud = "Лабораторная компьютерная аудитория 3430 предназначена для проведения практических занятий, семинаров и самостоятельной работы студентов, связанных с использованием компьютеров. \nОна оборудована: \n* Компьютерами с необходимым программным обеспечением \n* Сенсорной доской \n"
                    // Добавление в базу данных АУДИТОРИИ
                    audienceRepository.create(Audience(numberOfAudience = audienceNumber, description = descriptorAud))
                }
            }
        } catch (e: Exception){
            e.printStackTrace()
        }
    }
}