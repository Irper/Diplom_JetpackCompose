package com.example.network

/*
*
* Модель объекта, который будет получаться по сети
* */
data class Post(
    val userId: Int = 0,
    val id: Int = 0,
    val title: String = "",
    val completed: Boolean = false
)