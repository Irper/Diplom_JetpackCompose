package ru.vovan.diplomcompose.network.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okhttp3.FormBody
import retrofit2.Retrofit
import ru.vovan.diplomcompose.network.network.TimetableAPI

class TimetableRepositoryImpl(private val retrofit: Retrofit): TimetableRepository {
    override fun getAllTimetable(): Flow<String> =
        flow {
            val response = retrofit.create(TimetableAPI::class.java).getAllTimetable( FormBody.Builder().add("AudID", "101").build())
            emit(response.toString())
        }
}