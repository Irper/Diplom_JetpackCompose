package ru.vovan.diplomcompose.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

/*@Entity(tableName = "lessons", primaryKeys = ["numberOfLesson","itemName", "date"])*/
@Entity(tableName = "lessons") data class Lesson (
    @PrimaryKey(autoGenerate = true) val id: Long,
    val numberOfLesson : Int,
    val itemName : String,
    val date : String,
    val group : List<String>,
    val itemType : String,
    val lecturer : String
)