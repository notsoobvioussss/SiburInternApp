package com.example.myapplication.presentation.activity

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.repository.SettingsRepository
import com.example.myapplication.presentation.util.other.Screen
import com.example.myapplication.presentation.util.ui.other.Settings
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking

class MainViewModel(
    private val settingsRepository: SettingsRepository
) : ViewModel() {
    private val _currentScreen: MutableState<Screen> = mutableStateOf(Screen.Catalog)
    val currentScreen by _currentScreen

    private val _settings: MutableState<Settings> = mutableStateOf(Settings.Default())
    val settings: Settings by _settings

    init {
        runBlocking {
            _settings.value = settingsRepository.getSettings()
            _currentScreen.value = Screen.Catalog
        }

        settingsRepository.getSettingsAsFlow().onEach {
            _settings.value = it
        }.launchIn(viewModelScope)

    }

    fun updateCurrentScreen(screen: Screen) {
        _currentScreen.value = screen
    }
}