package ru.vovan.diplomcompose.database.repository

import kotlinx.coroutines.flow.Flow
import ru.vovan.diplomcompose.database.entity.Announcement
import java.util.UUID

interface AnnouncementRepository {
    suspend fun create(t: Announcement)
    fun readAll(): Flow<List<Announcement>>
    suspend fun read(id: UUID): Announcement?
    suspend fun update(t: Announcement)
    suspend fun delete(t: Announcement)
}