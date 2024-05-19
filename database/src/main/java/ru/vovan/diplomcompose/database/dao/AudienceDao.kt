package ru.vovan.diplomcompose.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import ru.vovan.diplomcompose.database.entity.Audience
import ru.vovan.diplomcompose.database.entity.AudienceWithLessons
import ru.vovan.diplomcompose.database.entity.Lesson

@Dao
interface AudienceDao {
    @Transaction
    @Query("SELECT * FROM audience")
    fun getAudienceWithLessons(): Flow<List<AudienceWithLessons>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(audience : Audience)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(lesson : Lesson)
    @Update
    suspend fun update(audience : Audience)
    @Delete
    suspend fun delete(audience : Audience)
    @Query("DELETE FROM audience")
    suspend fun deleteAllAudience()
    @Query("DELETE FROM lessons")
    suspend fun deleteAllLesson()
    @Query("SELECT * FROM lessons WHERE date = :date")
    fun readLessonByDate(date : String) :  Flow<List<Lesson>>
    @Query("SELECT * FROM audience")
    fun readAll(): Flow<List<Audience>>
    @Query("SELECT * FROM audience WHERE numberOfAudience = :id")
    suspend fun readById(id : String) : Audience?
}