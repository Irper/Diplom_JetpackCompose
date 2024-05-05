package edu.festu.ivankuznetsov.networkcomposeapp.repository

import kotlinx.coroutines.flow.Flow
import ru.vovan.compose.network.model.Post

/*
* Интерфейс, описывающий, что будем делать с сетью
* */
interface PostRepository{
    fun getAllPosts(): Flow<List<Post>>
}