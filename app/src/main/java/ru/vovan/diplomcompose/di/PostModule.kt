package ru.vovan.diplomcompose.di

import com.example.network.NetworkObject
import com.example.network.PostRepository
import com.example.network.PostRepositoryImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.vovan.diplomcompose.viewmodel.PostViewModel

/*
* Koin для того, чтобы обеспечить работу VM с использованием PostRepository
* */
val postModule = module {
    single<PostRepository> {
        PostRepositoryImpl(NetworkObject.retrofit)
    }
    viewModel { PostViewModel(get()) }
}