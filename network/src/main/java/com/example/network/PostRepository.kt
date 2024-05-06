package com.example.network

import kotlinx.coroutines.flow.Flow

/*
* Интерфейс, описывающий, что будем делать с сетью
* */
interface PostRepository{
    fun getAllPosts(): Flow<List<Post>>
}