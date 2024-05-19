package ru.vovan.diplomcompose.network.network

import retrofit2.http.GET
import retrofit2.http.POST
import ru.vovan.diplomcompose.network.model.Post

/*
* API для взаимодействия. Поставляется одиночке для работы.
* ОБРАТИТЕ ВНИМАНИЕ, функция getAllPosts - suspend!
* */
interface PostAPI {
    @GET("todos/")
    suspend fun getAllPosts() :List<Post>
}