package ru.vovan.diplomcompose.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.coroutines.flow.Flow
import java.util.UUID

@Entity(tableName = "lessons")
data class Lesson (
    @PrimaryKey
    val id: UUID = UUID.randomUUID(),
    val audienceId : String,
    val numberOfLesson : Int,
    val itemName : String,
    val date : String,
    val group : String,
    /*val group : List<String>,*/
    val itemType : String,
    val lecturer : String,

    // Начало урока
    var time_begin : String = "",
    // Конец урока
    var time_end : String = ""
){
    init {
        setTime(this.numberOfLesson)
    }
    private fun setTime(number : Int) {
        when (number) {
            1 -> {
                this.time_begin = "08:05"
                this.time_end = "09:35"
            }

            2 -> {
                this.time_begin = "09:50"
                this.time_end = "11:20"
            }

            3 -> {
                this.time_begin = "11:35"
                this.time_end = "13:05"
            }

            4 -> {
                this.time_begin = "13:35"
                this.time_end = "15:05"
            }

            5 -> {
                this.time_begin = "15:15"
                this.time_end = "16:45"
            }

            6 -> {
                this.time_begin = "16:55"
                this.time_end = "18:25"
            }
        }
    }
}