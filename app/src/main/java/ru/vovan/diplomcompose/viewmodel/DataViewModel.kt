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
    fun retrieveAnnouncement() = announcementRepository.readAll()
    private suspend fun browserAnnouncement(announcementsFlow: Flow<List<Post>> = getAllPosts()) {
        announcementsFlow.collect {
            if (it.isNotEmpty()) {
                announcementRepository.deleteAll()
                val currentDate: Date = Date()
                val dateFormat: DateFormat = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
                val dateText: String = dateFormat.format(currentDate)

                it.forEach{item ->
                    announcementRepository.create(Announcement(text =  item.title, date = dateText))
                }
            }
        }
    }

}