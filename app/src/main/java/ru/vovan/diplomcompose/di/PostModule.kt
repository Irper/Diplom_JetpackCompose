package ru.vovan.diplomcompose.di

import ru.vovan.diplomcompose.network.network.NetworkObject
import ru.vovan.diplomcompose.network.repository.PostRepository
import ru.vovan.diplomcompose.network.repository.PostRepositoryImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.vovan.diplomcompose.database.repository.AudienceRepository
import ru.vovan.diplomcompose.database.repository.AudienceRepositoryImpl
import ru.vovan.diplomcompose.viewmodel.PostViewModel

/*
* Koin для того, чтобы обеспечить работу VM с использованием PostRepository
* */
val postModule = module {
    single<PostRepository> {
        PostRepositoryImpl(NetworkObject.retrofit)
    }
    single<AudienceRepository>{
        AudienceRepositoryImpl()
    }
    viewModel { PostViewModel(get()) }
}