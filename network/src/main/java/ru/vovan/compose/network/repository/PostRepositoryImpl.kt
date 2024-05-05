package edu.festu.ivankuznetsov.networkcomposeapp.repository

import edu.festu.ivankuznetsov.networkcomposeapp.network.PostAPI
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Retrofit
import ru.vovan.compose.network.model.Post

/*
* Будем брать посты с сетевого ресурса и паковать во flow
* */
class PostRepositoryImpl(private val retrofit: Retrofit) : PostRepository {
    override fun getAllPosts(): Flow<List<Post>> =
        flow { emit(retrofit.create(PostAPI::class.java).getAllPosts()) }
}