package edu.festu.ivankuznetsov.networkcomposeapp.network


import retrofit2.http.GET
import ru.vovan.compose.network.model.Post

/*
* API для взаимодействия. Поставляется одиночке для работы.
* ОБРАТИТЕ ВНИМАНИЕ, функция getAllPosts - suspend!
* */
interface PostAPI {
    @GET("todos/")
    suspend fun getAllPosts() :List<Post>

}