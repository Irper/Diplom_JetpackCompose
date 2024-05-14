package ru.vovan.diplomcompose.di

import org.koin.android.ext.koin.androidContext
import ru.vovan.diplomcompose.network.network.PostNetworkObject
import ru.vovan.diplomcompose.network.repository.PostRepository
import ru.vovan.diplomcompose.network.repository.PostRepositoryImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.vovan.diplomcompose.database.StandDatabase
import ru.vovan.diplomcompose.database.repository.AnnouncementRepository
import ru.vovan.diplomcompose.database.repository.AnnouncementRepositoryImpl
import ru.vovan.diplomcompose.database.repository.AudienceRepository
import ru.vovan.diplomcompose.database.repository.AudienceRepositoryImpl
import ru.vovan.diplomcompose.network.network.TimetableNetworkObject
import ru.vovan.diplomcompose.network.repository.TimetableRepository
import ru.vovan.diplomcompose.network.repository.TimetableRepositoryImpl
import ru.vovan.diplomcompose.viewmodel.DataViewModel


val dataModule = module {
    single<PostRepository> {
        PostRepositoryImpl(PostNetworkObject.retrofitPost)
    }
    single<TimetableRepository> {
        TimetableRepositoryImpl(TimetableNetworkObject.retrofitTimetable)
    }
    single<AnnouncementRepository> {
        AnnouncementRepositoryImpl(
            StandDatabase
                .getDatabase(this.androidContext())
                .announcementDao()
        )
    }
    single<AudienceRepository> {
        AudienceRepositoryImpl(
            StandDatabase
                .getDatabase(this.androidContext())
                .audienceDao()
        )
    }

    viewModel { DataViewModel(get(), get(), get(), get()) }
}