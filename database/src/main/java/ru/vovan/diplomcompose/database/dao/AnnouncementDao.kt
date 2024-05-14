package ru.vovan.diplomcompose.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import ru.vovan.diplomcompose.database.entity.Announcement
import java.util.UUID

@Dao
interface AnnouncementDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(announcement: Announcement)
    @Update
    suspend fun update(announcement: Announcement)
    @Delete
    suspend fun delete(announcement: Announcement)
    @Query("DELETE FROM announcements")
    suspend fun deleteAll()
    @Query("SELECT * FROM announcements")
    fun readAll(): Flow<List<Announcement>>
    @Query("SELECT * from announcements WHERE id = :id")
    suspend fun readById(id : UUID) : Announcement
}