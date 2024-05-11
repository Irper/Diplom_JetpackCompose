package ru.vovan.diplomcompose.database

import android.content.Context
import ru.vovan.diplomcompose.database.repository.AnnouncementRepository
import ru.vovan.diplomcompose.database.repository.AnnouncementRepositoryImpl
import ru.vovan.diplomcompose.database.repository.AudienceRepository
import ru.vovan.diplomcompose.database.repository.AudienceRepositoryImpl

/*
interface AppContainer {
    val audienceRepository: AudienceRepository
    val announcementRepository: AnnouncementRepository
}

class AppDataContainer(private val context: Context) : AppContainer {

    override val audienceRepository: AudienceRepository by lazy {
        AudienceRepositoryImpl(AudienceDatabase.getDatabase(context).audienceDao())
    }
    override val announcementRepository: AnnouncementRepository by lazy {
        AnnouncementRepositoryImpl(AudienceDatabase.getDatabase(context).announcementDao())
    }
}*/
