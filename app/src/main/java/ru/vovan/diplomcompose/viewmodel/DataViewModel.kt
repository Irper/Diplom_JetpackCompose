package ru.vovan.diplomcompose.viewmodel

import androidx.lifecycle.ViewModel
import ru.vovan.diplomcompose.database.entity.Announcement
import ru.vovan.diplomcompose.database.entity.Audience
import ru.vovan.diplomcompose.database.repository.AnnouncementRepository
import ru.vovan.diplomcompose.database.repository.AudienceRepository
import ru.vovan.diplomcompose.network.repository.PostRepository
import java.util.UUID

class DataViewModel(
    private val postRepository: PostRepository,
    private val audienceRepository: AudienceRepository,
    private val announcementRepository: AnnouncementRepository
): ViewModel() {
    fun getAllPosts() = postRepository.getAllPosts()

    // Audience
    fun retrieveAudience() = audienceRepository.readAll()
    suspend fun create(audience: Audience){ audienceRepository.create(audience) }
    suspend fun read(id: String){ audienceRepository.read(id) }
    suspend fun update(audience: Audience){ audienceRepository.update(audience) }
    suspend fun delete(audience: Audience){ audienceRepository.delete(audience) }
    fun retrieveAudienceWithLessons() = audienceRepository.readAllAudienceWithLessons()

    // Announcement
    suspend fun create(announcement: Announcement) { announcementRepository.create(announcement) }
    fun retrieveAnnouncement() = announcementRepository.readAll()
    suspend fun read(id: UUID) { announcementRepository.read(id) }
    suspend fun update(announcement: Announcement) { announcementRepository.update(announcement) }
    suspend fun delete(announcement: Announcement) { announcementRepository.delete(announcement) }
}