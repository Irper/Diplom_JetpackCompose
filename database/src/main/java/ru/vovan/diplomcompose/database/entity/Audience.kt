package ru.vovan.diplomcompose.database.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.vovan.diplomcompose.database.entity.embedded.Lesson

@Entity(tableName = "audience")
data class Audience (
    @PrimaryKey
    val numberOfAudience : String,
    @Embedded
    val lessons : Lesson
)