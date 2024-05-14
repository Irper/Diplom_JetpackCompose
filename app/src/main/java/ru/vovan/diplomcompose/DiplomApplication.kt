package ru.vovan.diplomcompose

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import ru.vovan.diplomcompose.di.dataModule

class DiplomApplication : Application(){

        override fun onCreate() {
            super.onCreate()

            startKoin{
                androidLogger()
                androidContext(this@DiplomApplication)
                modules(dataModule)
            }
        }
}