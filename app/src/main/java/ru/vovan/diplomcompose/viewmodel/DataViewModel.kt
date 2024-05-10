package ru.vovan.diplomcompose.viewmodel

import androidx.lifecycle.ViewModel
import ru.vovan.diplomcompose.database.entity.Audience
import ru.vovan.diplomcompose.database.repository.AnnouncementRepository
import ru.vovan.diplomcompose.database.repository.AudienceRepository
import ru.vovan.diplomcompose.network.repository.PostRepository

class DataViewModel(
    private val postRepository: PostRepository,
    private val audienceRepository: AudienceRepository
): ViewModel() {
    fun getAllPosts() = postRepository.getAllPosts()
    fun retrieveAudience() = audienceRepository.readAll()
    suspend fun create(audience: Audience){ audienceRepository.create(audience) }
    suspend fun read(id: String){ audienceRepository.read(id) }
    suspend fun update(audience: Audience){ audienceRepository.update(audience) }
    suspend fun delete(audience: Audience){ audienceRepository.delete(audience) }
    fun retrieveAudienceWithLessons() = audienceRepository.readAllAudienceWithLessons()


}