package ru.vovan.diplomcompose.network.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Retrofit
import ru.vovan.diplomcompose.network.model.Post
import ru.vovan.diplomcompose.network.network.PostAPI

/*
* Будем брать посты с сетевого ресурса и паковать во flow
* */
class PostRepositoryImpl(private val retrofit: Retrofit) : PostRepository {
    override fun getAllPosts(): Flow<List<Post>> =
        flow { emit(retrofit.create(PostAPI::class.java).getAllPosts()) }
}