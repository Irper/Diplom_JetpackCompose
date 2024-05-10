package ru.vovan.diplomcompose.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "announcements")
data class Announcement (
    @PrimaryKey
    //todo add type converter
    val id: UUID = UUID.randomUUID(),
    var text : String,
    var date : String
)