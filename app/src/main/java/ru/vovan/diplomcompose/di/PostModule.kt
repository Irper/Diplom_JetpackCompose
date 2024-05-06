package ru.vovan.diplomcompose.di

import ru.vovan.diplomcompose.network.network.NetworkObject
import ru.vovan.diplomcompose.network.repository.PostRepository
import ru.vovan.diplomcompose.network.repository.PostRepositoryImpl
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