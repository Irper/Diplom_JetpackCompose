package ru.vovan.diplomcompose.di

import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.vovan.diplomcompose.database.StandDatabase

val databaseModule = module {
    single<EventRepository> {
        EventRepositoryImpl(
            StandDatabase
                .getDatabase(this.androidContext())
                .eventDao()
        )
    }
    viewModel { EventListViewModel(get()) }
}
