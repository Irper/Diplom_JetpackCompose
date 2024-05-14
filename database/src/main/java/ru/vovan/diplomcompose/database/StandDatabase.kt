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
import ru.vovan.diplomcompose.database.entity.Audience
import ru.vovan.diplomcompose.database.entity.Lesson

@Database(entities = [Audience::class,Lesson::class,Announcement::class], version = 2, exportSchema = false)
@TypeConverters( value = [UUIDConverter::class])
abstract class StandDatabase : RoomDatabase() {
    abstract fun audienceDao(): AudienceDao

    abstract fun announcementDao(): AnnouncementDao
    companion object {
        @Volatile
        private var Instance: StandDatabase? = null
        @OptIn(InternalCoroutinesApi::class)
        fun getDatabase(context: Context): StandDatabase {
            return Instance ?: kotlinx.coroutines.internal.synchronized(this) {
                Room.databaseBuilder(context, StandDatabase::class.java, "audience_database")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }
        }
    }


}