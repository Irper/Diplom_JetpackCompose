package ru.vovan.diplomcompose.network.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/*
* Одиночка для сетевого взаимодействия
* */
object NetworkObject {
    @Volatile
    var retrofitPost = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    @Volatile
    var retrofitTimetable = Retrofit.Builder()
        .baseUrl("https://dvgups.ru/index.php?Itemid=1246&option=com_timetable&view=newtimetable")
        .build()
}