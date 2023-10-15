package com.example.manualdependencyinjection

import android.app.Application
import com.example.manualdependencyinjection.di.AppModule
import com.example.manualdependencyinjection.di.AppModuleImpl

class MyApp: Application() {
    companion object {
        lateinit var appModule: AppModule;
    }

    override fun onCreate() {
        super.onCreate()
        appModule = AppModuleImpl(this)
    }
}