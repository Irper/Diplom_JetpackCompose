package ru.vovan.compose.network.viewmodel

import androidx.lifecycle.ViewModel
import edu.festu.ivankuznetsov.networkcomposeapp.repository.PostRepository

/*
* Будем использовать VM для того, чтобы обращаться к сети
* */
class PostViewModel(private val postRepository: PostRepository):ViewModel() {
    fun getAllPosts() = postRepository.getAllPosts()
}