package com.example.network

import retrofit2.http.GET

/*
* API для взаимодействия. Поставляется одиночке для работы.
* ОБРАТИТЕ ВНИМАНИЕ, функция getAllPosts - suspend!
* */
interface PostAPI {
    @GET("todos/")
    suspend fun getAllPosts() :List<Post>

}