package ru.vovan.diplomcompose

class Audience constructor(
    _number_of_audience: Int,
    _lessons : List<Lesson>
) {
    // Номер аудитории
    var number_of_audience : Int = _number_of_audience
    // Записи об уроках текущего кабинета
    var lessons : List<Lesson> = _lessons
}