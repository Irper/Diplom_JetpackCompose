package ru.vovan.diplomcompose.network.repository

import kotlinx.coroutines.flow.Flow
import ru.vovan.diplomcompose.network.model.Post

/*
* Интерфейс, описывающий, что будем делать с сетью
* */
interface PostRepository{
    fun getAllPosts(): Flow<List<Post>>
}