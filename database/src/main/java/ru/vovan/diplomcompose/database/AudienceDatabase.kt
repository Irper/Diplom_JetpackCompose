package ru.vovan.diplomcompose.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized
import ru.vovan.diplomcompose.database.converters.UUIDConverter
import ru.vovan.diplomcompose.database.dao.AnnouncementDao
import ru.vovan.diplomcompose.database.dao.AudienceDao
import ru.vovan.diplomcompose.database.entity.Announcement
import ru.vovan.diplomcompose.database.entity.Audience
import ru.vovan.diplomcompose.database.entity.Lesson


@Database(entities = [Audience::class, Lesson::class], version = 1, exportSchema = false)
@TypeConverters( value = [UUIDConverter::class])
abstract class AudienceDatabase : RoomDatabase() {
    abstract fun audienceDao(): AudienceDao
    companion object {
        @Volatile
        private var Instance: AudienceDatabase? = null
        @OptIn(InternalCoroutinesApi::class)
        fun getDatabase(context: Context): AudienceDatabase {
            return Instance ?: synchronized(this){
                Room.databaseBuilder(context, AudienceDatabase::class.java, "audience_database")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }
        }
    }


}