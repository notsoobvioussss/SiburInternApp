package com.example.myapplication.domain.repository

import com.example.myapplication.presentation.util.ui.other.HeadlineOverflowBehaviour
import com.example.myapplication.presentation.util.ui.other.Settings
import com.t8rin.dynamic.theme.ColorTuple
import kotlinx.coroutines.flow.Flow

interface SettingsRepository {

    fun getSettingsAsFlow(): Flow<Settings>

    suspend fun getSettings(): Settings

    suspend fun updateAmoledMode(value: Boolean)

    suspend fun updateIsDarkMode(value: Boolean)

    suspend fun updateUseDynamicColors(value: Boolean)

    suspend fun updateBordersEnabled(value: Boolean)

    suspend fun updateColorTuple(value: ColorTuple)

    suspend fun updateHeadlineOverflowBehaviour(value: HeadlineOverflowBehaviour)
}