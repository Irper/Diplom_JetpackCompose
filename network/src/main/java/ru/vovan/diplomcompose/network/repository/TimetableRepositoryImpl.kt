package ru.vovan.diplomcompose.network.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Retrofit
import ru.vovan.diplomcompose.network.model.Timetable
import ru.vovan.diplomcompose.network.network.TimetableAPI

class TimetableRepositoryImpl(private val retrofit: Retrofit): TimetableRepository {
    override fun getAllTimetable(): Flow<Timetable> =
        flow { emit(retrofit.create(TimetableAPI::class.java).getAllTimetable()) }
}