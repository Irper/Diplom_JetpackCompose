package ru.vovan.diplomcompose.viewmodel

import androidx.lifecycle.ViewModel
import ru.vovan.diplomcompose.database.entity.Audience
import ru.vovan.diplomcompose.database.repository.AudienceRepository

class EventListViewModel(private val eventRepository: AudienceRepository): ViewModel() {
    fun retrieveEvents() = eventRepository.readAll()
    suspend fun add(audience: Audience){ eventRepository.create(audience) }
}
