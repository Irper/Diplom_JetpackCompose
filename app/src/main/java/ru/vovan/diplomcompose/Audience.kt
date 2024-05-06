package ru.vovan.diplomcompose

import ru.vovan.diplomcompose.network.model.Post
import java.util.Calendar

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
        listPosts.forEach{
            announcement.add(Announcement(it.title, Calendar.getInstance().time.toString()))
        }
    }
}