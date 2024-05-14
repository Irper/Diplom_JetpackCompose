package ru.vovan.diplomcompose.ui.model

import ru.vovan.diplomcompose.database.entity.Audience
import ru.vovan.diplomcompose.database.entity.Lesson

class AudienceModel(audience: Audience, listLesson: ArrayList<Lesson>) {
    // Номер аудитории
    var numberOfAudience : String = audience.numberOfAudience
    // Описание кабинета
    val description : String = audience.description
    // Список занятий
    val listLesson : ArrayList<Lesson> = listLesson
}