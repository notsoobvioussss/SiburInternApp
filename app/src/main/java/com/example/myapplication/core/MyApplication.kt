package com.example.myapplication.core

import android.app.Application
import com.example.myapplication.core.di.dataModule
import com.example.myapplication.core.di.dataStoreModule
import com.example.myapplication.core.di.networkModule
import com.example.myapplication.core.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(
                dataModule,
                dataStoreModule,
                networkModule,
                viewModelModule
            )
        }
    }
}