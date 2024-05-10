package ru.vovan.diplomcompose.di

import org.koin.android.ext.koin.androidContext
import ru.vovan.diplomcompose.network.network.NetworkObject
import ru.vovan.diplomcompose.network.repository.PostRepository
import ru.vovan.diplomcompose.network.repository.PostRepositoryImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.vovan.diplomcompose.database.StandDatabase
import ru.vovan.diplomcompose.database.entity.Audience
import ru.vovan.diplomcompose.database.repository.AnnouncementRepository
import ru.vovan.diplomcompose.database.repository.AnnouncementRepositoryImpl
import ru.vovan.diplomcompose.database.repository.AudienceRepository
import ru.vovan.diplomcompose.database.repository.AudienceRepositoryImpl
import ru.vovan.diplomcompose.viewmodel.DataViewModel

/*
* Koin для того, чтобы обеспечить работу VM с использованием PostRepository
* */
val dataModule = module {
    single<PostRepository> {
        PostRepositoryImpl(NetworkObject.retrofit)
    }
    single<AudienceRepository> {
        AudienceRepositoryImpl(
            StandDatabase
                .getDatabase(this.androidContext())
                .audienceDao()
        )
    }

    viewModel { DataViewModel(get(), get()) }
}