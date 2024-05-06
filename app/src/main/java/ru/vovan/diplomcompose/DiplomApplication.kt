package ru.vovan.diplomcompose

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import ru.vovan.diplomcompose.di.postModule

class DiplomApplication : Application(){
        //  lateinit var container: AppContainer

        override fun onCreate() {
            super.onCreate()
            //  container = AppDataContainer(this)

            startKoin{
                androidLogger()
                androidContext(this@DiplomApplication)
                modules(postModule)
            }
        }
}