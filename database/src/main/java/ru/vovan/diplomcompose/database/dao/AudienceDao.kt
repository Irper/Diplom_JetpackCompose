package ru.vovan.diplomcompose.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import ru.vovan.diplomcompose.database.entity.Audience
import java.util.UUID

@Dao
interface AudienceDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(audience : Audience)
    @Update
    suspend fun update(audience : Audience)
    @Delete
    suspend fun delete(audience : Audience)
    @Query("SELECT * FROM audience")
    fun readAll(): Flow<List<Audience>>
    @Query("SELECT * FROM audience WHERE numberOfAudience = :id")
    suspend fun readById(id: String):Audience?
}