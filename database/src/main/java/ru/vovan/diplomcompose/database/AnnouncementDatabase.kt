package ru.vovan.diplomcompose.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import kotlinx.coroutines.InternalCoroutinesApi
import ru.vovan.diplomcompose.database.converters.UUIDConverter
import ru.vovan.diplomcompose.database.dao.AnnouncementDao
import ru.vovan.diplomcompose.database.dao.AudienceDao
import ru.vovan.diplomcompose.database.entity.Announcement

@Database(entities = [Announcement::class], version = 1, exportSchema = false)
@TypeConverters( value = [UUIDConverter::class])
abstract class AnnouncementDatabase : RoomDatabase() {
    abstract fun announcementDao(): AnnouncementDao
    companion object {
        @Volatile
        private var Instance: AnnouncementDatabase? = null
        @OptIn(InternalCoroutinesApi::class)
        fun getDatabase(context: Context): AnnouncementDatabase {
            return Instance ?: kotlinx.coroutines.internal.synchronized(this) {
                Room.databaseBuilder(context, AnnouncementDatabase::class.java, "audience_database")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }
        }
    }


}