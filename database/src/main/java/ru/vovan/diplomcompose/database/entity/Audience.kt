package ru.vovan.diplomcompose.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "audience")
data class Audience (
    @PrimaryKey
    val numberOfAudience : String,
    @ColumnInfo(name = "desc")
    val description : String
)