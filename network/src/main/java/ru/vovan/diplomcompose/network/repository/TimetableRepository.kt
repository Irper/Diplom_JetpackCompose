package ru.vovan.diplomcompose.network.repository

import kotlinx.coroutines.flow.Flow
import ru.vovan.diplomcompose.network.model.Post
import ru.vovan.diplomcompose.network.model.Timetable

interface TimetableRepository {
    fun getAllTimetable(): Flow<Timetable>
}