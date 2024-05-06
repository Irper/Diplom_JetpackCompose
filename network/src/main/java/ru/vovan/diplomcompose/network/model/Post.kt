package ru.vovan.diplomcompose.network.model

/*
* Модель объекта, который будет получаться по сети
* */
data class Post(
    val userId: Int = 0,
    val id: Int = 0,
    val title: String = "",
    val completed: Boolean = false
)