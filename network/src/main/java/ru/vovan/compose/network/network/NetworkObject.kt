package edu.festu.ivankuznetsov.networkcomposeapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/*
* Одиночка для сетевого взаимодействия
* */
object NetworkObject {
    @Volatile
    var retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}