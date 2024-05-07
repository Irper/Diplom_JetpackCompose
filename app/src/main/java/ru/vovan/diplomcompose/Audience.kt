package ru.vovan.diplomcompose

import ru.vovan.diplomcompose.network.model.Post
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class Audience constructor(
    _number_of_audience: Int,
    _lessons : ArrayList<Lesson>,
    _announcement : ArrayList<Announcement>
) {
    // Номер аудитории
    var number_of_audience : Int = _number_of_audience
    // Записи об уроках текущего кабинета
    var lessons : ArrayList<Lesson> = _lessons
    // Список объявлений
    var announcement : ArrayList<Announcement> = _announcement


    fun setAnnouncement(listPosts : List<Post>){
        // Текущее время
        val currentDate: Date = Date()
        // Форматирование времени как "день.месяц.год"
        val dateFormat: DateFormat = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
        val dateText: String = dateFormat.format(currentDate)

        listPosts.forEach{
            announcement.add(Announcement(it.title, dateText))
        }
    }
}