package ru.vovan.diplomcompose.di

import org.koin.android.ext.koin.androidContext
import ru.vovan.diplomcompose.network.network.NetworkObject
import ru.vovan.diplomcompose.network.repository.PostRepository
import ru.vovan.diplomcompose.network.repository.PostRepositoryImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.vovan.diplomcompose.database.AnnouncementDatabase
import ru.vovan.diplomcompose.database.AudienceDatabase
import ru.vovan.diplomcompose.database.repository.AnnouncementRepository
import ru.vovan.diplomcompose.database.repository.AnnouncementRepositoryImpl
import ru.vovan.diplomcompose.database.repository.AudienceRepository
import ru.vovan.diplomcompose.database.repository.AudienceRepositoryImpl
import ru.vovan.diplomcompose.viewmodel.DataViewModel


val dataModule = module {
    single<PostRepository> {
        PostRepositoryImpl(NetworkObject.retrofitPost)
    }
    single<AnnouncementRepository> {
        AnnouncementRepositoryImpl(
            AnnouncementDatabase
                .getDatabase(this.androidContext())
                .announcementDao()
        )
    }
    single<AudienceRepository> {
        AudienceRepositoryImpl(
            AnnouncementDatabase
                .getDatabase(this.androidContext())
                .audienceDao()
        )
    }

    viewModel { DataViewModel(get(), get(), get()) }
}