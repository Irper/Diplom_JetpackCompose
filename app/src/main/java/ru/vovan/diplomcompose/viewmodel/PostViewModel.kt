package ru.vovan.diplomcompose.viewmodel

import androidx.lifecycle.ViewModel
import com.example.network.PostRepository

class PostViewModel(private val postRepository: PostRepository): ViewModel() {
    fun getAllPosts() = postRepository.getAllPosts()
}