package ru.vovan.diplomcompose.database.repository

import kotlinx.coroutines.flow.Flow
import ru.vovan.diplomcompose.database.entity.Audience
import ru.vovan.diplomcompose.database.entity.AudienceWithLessons
import ru.vovan.diplomcompose.database.entity.Lesson

interface AudienceRepository {
    suspend fun create(t: Audience)
    suspend fun create(t: Lesson)
    fun readAll(): Flow<List<Audience>>
    suspend fun read(id: String): Audience?
    fun readLessonByDate(date: String): Flow<List<Lesson>>
    suspend fun update(t: Audience)
    suspend fun delete(t: Audience)
    suspend fun deleteAllAudience()
    suspend fun deleteAllLesson()
    fun readAllAudienceWithLessons(): Flow<List<AudienceWithLessons>>
}
