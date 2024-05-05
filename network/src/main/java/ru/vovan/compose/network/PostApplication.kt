package ru.vovan.compose.network

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import ru.vovan.compose.network.di.postModule

class PostApplication: Application(){
    //  lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        //  container = AppDataContainer(this)

        startKoin{
            androidLogger()
            androidContext(this@PostApplication)
            modules(postModule)
        }

    }
}