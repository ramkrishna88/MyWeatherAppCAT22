package com.example.myweatherappcat22

import android.app.Application
import com.example.myweatherappcat22.di.networkModule
import com.example.myweatherappcat22.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class WeatherApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@WeatherApp)
            modules(listOf(networkModule, viewModelModule))
        }
    }
}