package ru.vovan.diplomcompose.viewmodel

import androidx.lifecycle.ViewModel
import ru.vovan.diplomcompose.network.repository.PostRepository

/*
* Будем использовать VM для того, чтобы обращаться к сети
* */
class PostViewModel(private val postRepository: PostRepository): ViewModel() {
    fun getAllPosts() = postRepository.getAllPosts()
}