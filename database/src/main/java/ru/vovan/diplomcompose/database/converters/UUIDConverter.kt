package ru.vovan.diplomcompose.database.converters

import androidx.room.TypeConverter
import java.util.UUID


object UUIDConverter {
    @TypeConverter
    fun fromUUID(uuid: UUID): String {
        return uuid.toString()
    }

    @TypeConverter
    fun uuidFromString(string: String?): UUID {
        return UUID.fromString(string)
    }
}