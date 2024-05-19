package ru.vovan.diplomcompose.network.repository

import kotlinx.coroutines.flow.Flow

interface TimetableRepository {
    fun getAllTimetable(): Flow<String>
}