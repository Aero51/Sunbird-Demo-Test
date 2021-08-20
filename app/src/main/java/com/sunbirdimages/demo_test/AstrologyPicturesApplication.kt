package com.sunbirdimages.demo_test

import android.app.Application
import com.sunbirdimages.demo_test.di.appModule
import com.sunbirdimages.demo_test.di.repoModule
import com.sunbirdimages.demo_test.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AstrologyPicturesApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@AstrologyPicturesApplication)
            modules(listOf(appModule, repoModule, viewModelModule))
        }
    }
}