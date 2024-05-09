package ru.vovan.diplomcompose.database.repository

import kotlinx.coroutines.flow.Flow
import ru.vovan.diplomcompose.database.entity.Audience

interface AudienceRepository {
    suspend fun create(t: Audience)
    fun readAll(): Flow<List<Audience>>
    suspend fun read(id: String): Audience?
    suspend fun update(t: Audience)
    suspend fun delete(t: Audience)
}
