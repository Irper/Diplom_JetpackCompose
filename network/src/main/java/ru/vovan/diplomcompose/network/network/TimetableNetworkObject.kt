package ru.vovan.diplomcompose.network.network

import retrofit2.Retrofit

object TimetableNetworkObject {
    @Volatile
    var retrofitTimetable = Retrofit.Builder()
        .baseUrl("https://dvgups.ru")
        .build()
}