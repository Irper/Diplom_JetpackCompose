package ru.vovan.diplomcompose.ui.model

import ru.vovan.diplomcompose.database.entity.Announcement
import ru.vovan.diplomcompose.database.entity.Audience
import ru.vovan.diplomcompose.database.entity.Lesson
import ru.vovan.diplomcompose.network.model.Post
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class StandModel(audience: Audience, listLesson: ArrayList<Lesson>, listAnnouncement : ArrayList<Announcement>) {
    // Номер аудитории
    var numberOfAudience : String = audience.numberOfAudience
    // Описание кабинета
    val description : String = audience.description
    // Список занятий
    val listLesson : ArrayList<Lesson> = listLesson
    // Список занятий
    val listAnnouncement : ArrayList<Announcement> = listAnnouncement

    fun setAnnouncement (listPosts : List<Post>){
        // Текущее время
        val currentDate: Date = Date()
        // Форматирование времени как "день.месяц.год"
        val dateFormat: DateFormat = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
        val dateText: String = dateFormat.format(currentDate)

        listPosts.forEach{
            listAnnouncement.add(Announcement(text = it.title, date = dateText))
        }
    }
}