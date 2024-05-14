package ru.vovan.diplomcompose.network.network

import retrofit2.http.GET
import ru.vovan.diplomcompose.network.model.Timetable

interface TimetableAPI {
    @GET("index.php?Itemid=1246&option=com_timetable&view=newtimetable")
    suspend fun getAllTimetable() : Timetable
}