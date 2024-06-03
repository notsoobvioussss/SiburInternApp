package com.example.myapplication.core.di

import com.example.myapplication.presentation.activity.MainViewModel
import com.example.myapplication.presentation.screen.characters.CharacterViewModel
import com.example.myapplication.presentation.screen.profilescreen.SettingsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {
    viewModel { CharacterViewModel(get()) }
    viewModel { MainViewModel(get()) }
    viewModel {SettingsViewModel(get())}
}