package ru.vovan.diplomcompose.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import ru.vovan.diplomcompose.database.entity.Announcement
import ru.vovan.diplomcompose.database.entity.Audience
import ru.vovan.diplomcompose.database.repository.AnnouncementRepository
import ru.vovan.diplomcompose.database.repository.AudienceRepository
import ru.vovan.diplomcompose.network.model.Post
import ru.vovan.diplomcompose.network.repository.PostRepository
import ru.vovan.diplomcompose.network.repository.TimetableRepository
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.UUID

class DataViewModel(
    private val postRepository: PostRepository,
    private val timetableRepository: TimetableRepository,
    private val audienceRepository: AudienceRepository,
    private val announcementRepository: AnnouncementRepository
): ViewModel() {
    init {
        viewModelScope.launch {
            browserAnnouncement()
        }
    }
    private fun getAllPosts() = postRepository.getAllPosts()
    fun getAllTimetable() = timetableRepository.getAllTimetable()

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
    suspend fun update(announcement: Announcement) {
        announcementRepository.update(announcement)
    }
    private suspend fun browserAnnouncement(announcementsFlow: Flow<List<Post>> = getAllPosts()) {
        // Текущее время
        val currentDate: Date = Date()
        // Форматирование времени как "день.месяц.год"
        val dateFormat: DateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        val dateText: String = dateFormat.format(currentDate)

        announcementsFlow.collect { it ->
            it.forEach{item ->
                    announcementRepository.update(Announcement(text =  item.title, date = dateText))
            }
        }
    }

}