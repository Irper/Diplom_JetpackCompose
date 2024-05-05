package ru.vovan.compose.network.di



import edu.festu.ivankuznetsov.networkcomposeapp.network.NetworkObject
import edu.festu.ivankuznetsov.networkcomposeapp.repository.PostRepository
import edu.festu.ivankuznetsov.networkcomposeapp.repository.PostRepositoryImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.vovan.compose.network.viewmodel.PostViewModel

/*
* Koin для того, чтобы обеспечить работу VM с использованием PostRepository
* */
val postModule = module {
    single<PostRepository> {
        PostRepositoryImpl(NetworkObject.retrofit)
    }
    viewModel { PostViewModel(get()) }
}