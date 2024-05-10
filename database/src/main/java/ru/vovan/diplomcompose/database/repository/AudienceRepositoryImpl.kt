package ru.vovan.diplomcompose.database.repository

import kotlinx.coroutines.flow.Flow
import ru.vovan.diplomcompose.database.dao.AudienceDao
import ru.vovan.diplomcompose.database.entity.Audience
import ru.vovan.diplomcompose.database.entity.AudienceWithLessons
import ru.vovan.diplomcompose.database.repository.AudienceRepository

class AudienceRepositoryImpl(private val audienceDao: AudienceDao): AudienceRepository {
    override suspend fun create(t: Audience) = audienceDao.insert(t)
    override fun readAll(): Flow<List<Audience>> = audienceDao.readAll()
    override suspend fun read(id: String): Audience = audienceDao.readById(id)
    override suspend fun update(t: Audience)  = audienceDao.update(t)
    override suspend fun delete(t: Audience) = audienceDao.delete(t)
    override fun readAllAudienceWithLessons(): Flow<List<AudienceWithLessons>> = audienceDao.getAudienceWithLessons()
}