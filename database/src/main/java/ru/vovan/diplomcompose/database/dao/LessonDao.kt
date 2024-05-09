package ru.vovan.diplomcompose.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import ru.vovan.diplomcompose.database.entity.embedded.Lesson

@Dao
interface LessonDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(lesson: Lesson)
    @Update
    suspend fun update(lesson: Lesson)
    @Delete
    suspend fun delete(lesson: Lesson)
    @Query("SELECT * from lessons WHERE date = :date")
    fun getLesson(date : String) : Flow<Lesson>
}