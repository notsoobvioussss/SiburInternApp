package com.example.myapplication.core.di

import androidx.room.Room
import com.example.myapplication.data.local.dao.CharacterDao
import com.example.myapplication.data.local.database.AppDatabase
import com.example.myapplication.data.repository.CharacterRepositoryImpl
import com.example.myapplication.domain.repository.CharacterRepository
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val dataModule = module {
    single<AppDatabase> {
        Room.databaseBuilder(
            context = androidContext(),
            klass = AppDatabase::class.java,
            name = "appdatabase"
        ).build()
    }
    single<CharacterDao> { get<AppDatabase>().characterDao }
    singleOf(::CharacterRepositoryImpl) bind CharacterRepository::class
}
