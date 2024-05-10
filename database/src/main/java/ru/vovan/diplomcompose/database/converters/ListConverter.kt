package ru.vovan.diplomcompose.database.converters

import androidx.room.TypeConverter
import java.util.UUID

object ListConverter {
    @TypeConverter
    fun fromList(list: List<String>): String {
        return list.toString()
    }

    /*@TypeConverter
    fun uuidFromString(string: String?): List<String> {
        return UUID.fromString(string)
    }*/
}