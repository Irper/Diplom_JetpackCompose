package ru.vovan.diplomcompose

class Lesson constructor(
    _number_of_lesson : Int,
    _name : String,
    _group : List<String>,
    _subject : String,
    _lecturer : String
    ) {
    // Номер урока
    var number : Int = _number_of_lesson
    // Начало урока
    var time_begin : String = ""
    // Конец урока
    var time_end : String = ""
    // Название предмета
    var name : String = _name
    // Названия групп
    var group : List<String> = _group
    // Принадженость предмета (Лекция, Практика)
    var subject : String = _subject
    // ФИО преподавателя
    var lecturer : String = _lecturer

    init {
        setTime(this.number)
    }
    private fun setTime(number : Int){
        when (number){
            1 -> {
                this.time_begin = "08:05"
                this.time_end="09:35"
            }
            2 -> {
                this.time_begin = "09:50"
                this.time_end="11:20"
            }
            3 -> {
                this.time_begin = "11:35"
                this.time_end="13:05"
            }
            4 -> {
                this.time_begin = "13:35"
                this. time_end="15:05"
            }
            5 -> {
                this.time_begin = "15:15"
                this.time_end="16:45"
            }
            6 -> {
                this.time_begin = "16:55"
                this.time_end="18:25"
            }
        }
    }
}