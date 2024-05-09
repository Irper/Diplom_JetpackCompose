package ru.vovan.diplomcompose.database.entity.embedded

import androidx.room.ColumnInfo
import androidx.room.Entity

/*@Entity(tableName = "lessons", primaryKeys = ["numberOfLesson","itemName", "date"])*/
data class Lesson (
    val numberOfLesson : Int,
    val itemName : String,
    val date : String,
    val group : List<String>,
    val itemType : String,
    val lecturer : String
)