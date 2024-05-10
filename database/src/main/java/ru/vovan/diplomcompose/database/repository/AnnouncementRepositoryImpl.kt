package ru.vovan.diplomcompose.database.repository

import kotlinx.coroutines.flow.Flow
import ru.vovan.diplomcompose.database.dao.AnnouncementDao
import ru.vovan.diplomcompose.database.entity.Announcement
import java.util.UUID

class AnnouncementRepositoryImpl(private val announcementDao: AnnouncementDao): AnnouncementRepository {
    override suspend fun create(t: Announcement) = announcementDao.insert(t)
    override fun readAll(): Flow<List<Announcement>> = announcementDao.readAll()
    override suspend fun read(id: UUID): Announcement = announcementDao.readById(id)
    override suspend fun update(t: Announcement)  = announcementDao.update(t)
    override suspend fun delete(t: Announcement) = announcementDao.delete(t)
}