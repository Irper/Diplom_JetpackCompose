package ru.vovan.diplomcompose.network.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/*
* Одиночка для сетевого взаимодействия
*/
object PostNetworkObject {
    @Volatile
    var retrofitPost = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}