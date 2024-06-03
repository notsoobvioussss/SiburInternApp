package com.example.myapplication.presentation.util.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import com.example.myapplication.presentation.util.ui.other.LocalSettingsProvider
import com.t8rin.dynamic.theme.DynamicTheme
import com.t8rin.dynamic.theme.getAppColorTuple
import com.t8rin.dynamic.theme.rememberDynamicThemeState
import ru.tanexc.meal.presentation.util.ui.theme.backgroundDark
import ru.tanexc.meal.presentation.util.ui.theme.backgroundLight
import ru.tanexc.meal.presentation.util.ui.theme.errorContainerDark
import ru.tanexc.meal.presentation.util.ui.theme.errorContainerLight
import ru.tanexc.meal.presentation.util.ui.theme.errorDark
import ru.tanexc.meal.presentation.util.ui.theme.errorLight
import ru.tanexc.meal.presentation.util.ui.theme.inverseOnSurfaceDark
import ru.tanexc.meal.presentation.util.ui.theme.inverseOnSurfaceLight
import ru.tanexc.meal.presentation.util.ui.theme.inversePrimaryDark
import ru.tanexc.meal.presentation.util.ui.theme.inversePrimaryLight
import ru.tanexc.meal.presentation.util.ui.theme.inverseSurfaceDark
import ru.tanexc.meal.presentation.util.ui.theme.inverseSurfaceLight
import ru.tanexc.meal.presentation.util.ui.theme.onBackgroundDark
import ru.tanexc.meal.presentation.util.ui.theme.onBackgroundLight
import ru.tanexc.meal.presentation.util.ui.theme.onErrorContainerDark
import ru.tanexc.meal.presentation.util.ui.theme.onErrorContainerLight
import ru.tanexc.meal.presentation.util.ui.theme.onErrorDark
import ru.tanexc.meal.presentation.util.ui.theme.onErrorLight
import ru.tanexc.meal.presentation.util.ui.theme.onPrimaryContainerDark
import ru.tanexc.meal.presentation.util.ui.theme.onPrimaryContainerLight
import ru.tanexc.meal.presentation.util.ui.theme.onPrimaryDark
import ru.tanexc.meal.presentation.util.ui.theme.onPrimaryLight
import ru.tanexc.meal.presentation.util.ui.theme.onSecondaryContainerDark
import ru.tanexc.meal.presentation.util.ui.theme.onSecondaryContainerLight
import ru.tanexc.meal.presentation.util.ui.theme.onSecondaryDark
import ru.tanexc.meal.presentation.util.ui.theme.onSecondaryLight
import ru.tanexc.meal.presentation.util.ui.theme.onSurfaceDark
import ru.tanexc.meal.presentation.util.ui.theme.onSurfaceLight
import ru.tanexc.meal.presentation.util.ui.theme.onSurfaceVariantDark
import ru.tanexc.meal.presentation.util.ui.theme.onSurfaceVariantLight
import ru.tanexc.meal.presentation.util.ui.theme.onTertiaryContainerDark
import ru.tanexc.meal.presentation.util.ui.theme.onTertiaryContainerLight
import ru.tanexc.meal.presentation.util.ui.theme.onTertiaryDark
import ru.tanexc.meal.presentation.util.ui.theme.onTertiaryLight
import ru.tanexc.meal.presentation.util.ui.theme.outlineDark
import ru.tanexc.meal.presentation.util.ui.theme.outlineLight
import ru.tanexc.meal.presentation.util.ui.theme.outlineVariantDark
import ru.tanexc.meal.presentation.util.ui.theme.outlineVariantLight
import ru.tanexc.meal.presentation.util.ui.theme.primaryContainerDark
import ru.tanexc.meal.presentation.util.ui.theme.primaryContainerLight
import ru.tanexc.meal.presentation.util.ui.theme.primaryDark
import ru.tanexc.meal.presentation.util.ui.theme.primaryLight
import ru.tanexc.meal.presentation.util.ui.theme.scrimDark
import ru.tanexc.meal.presentation.util.ui.theme.scrimLight
import ru.tanexc.meal.presentation.util.ui.theme.secondaryContainerDark
import ru.tanexc.meal.presentation.util.ui.theme.secondaryContainerLight
import ru.tanexc.meal.presentation.util.ui.theme.secondaryDark
import ru.tanexc.meal.presentation.util.ui.theme.secondaryLight
import ru.tanexc.meal.presentation.util.ui.theme.surfaceBrightDark
import ru.tanexc.meal.presentation.util.ui.theme.surfaceBrightLight
import ru.tanexc.meal.presentation.util.ui.theme.surfaceDark
import ru.tanexc.meal.presentation.util.ui.theme.surfaceLight
import ru.tanexc.meal.presentation.util.ui.theme.surfaceVariantDark
import ru.tanexc.meal.presentation.util.ui.theme.surfaceVariantLight
import ru.tanexc.meal.presentation.util.ui.theme.tertiaryContainerDark
import ru.tanexc.meal.presentation.util.ui.theme.tertiaryContainerLight
import ru.tanexc.meal.presentation.util.ui.theme.tertiaryDark
import ru.tanexc.meal.presentation.util.ui.theme.tertiaryLight

private val LightColors = lightColorScheme(
    primary = primaryLight,
    onPrimary = onPrimaryLight,
    primaryContainer = primaryContainerLight,
    onPrimaryContainer = onPrimaryContainerLight,
    secondary = secondaryLight,
    onSecondary = onSecondaryLight,
    secondaryContainer = secondaryContainerLight,
    onSecondaryContainer = onSecondaryContainerLight,
    tertiary = tertiaryLight,
    onTertiary = onTertiaryLight,
    tertiaryContainer = tertiaryContainerLight,
    onTertiaryContainer = onTertiaryContainerLight,
    error = errorLight,
    errorContainer = errorContainerLight,
    onError = onErrorLight,
    onErrorContainer = onErrorContainerLight,
    background = backgroundLight,
    onBackground = onBackgroundLight,
    surface = surfaceLight,
    onSurface = onSurfaceLight,
    surfaceVariant = surfaceVariantLight,
    onSurfaceVariant = onSurfaceVariantLight,
    outline = outlineLight,
    inverseOnSurface = inverseOnSurfaceLight,
    inverseSurface = inverseSurfaceLight,
    inversePrimary = inversePrimaryLight,
    surfaceTint = surfaceBrightLight,
    outlineVariant = outlineVariantLight,
    scrim = scrimLight,
)


private val DarkColors = darkColorScheme(
    primary = primaryDark,
    onPrimary = onPrimaryDark,
    primaryContainer = primaryContainerDark,
    onPrimaryContainer = onPrimaryContainerDark,
    secondary = secondaryDark,
    onSecondary = onSecondaryDark,
    secondaryContainer = secondaryContainerDark,
    onSecondaryContainer = onSecondaryContainerDark,
    tertiary = tertiaryDark,
    onTertiary = onTertiaryDark,
    tertiaryContainer = tertiaryContainerDark,
    onTertiaryContainer = onTertiaryContainerDark,
    error = errorDark,
    errorContainer = errorContainerDark,
    onError = onErrorDark,
    onErrorContainer = onErrorContainerDark,
    background = backgroundDark,
    onBackground = onBackgroundDark,
    surface = surfaceDark,
    onSurface = onSurfaceDark,
    surfaceVariant = surfaceVariantDark,
    onSurfaceVariant = onSurfaceVariantDark,
    outline = outlineDark,
    inverseOnSurface = inverseOnSurfaceDark,
    inverseSurface = inverseSurfaceDark,
    inversePrimary = inversePrimaryDark,
    surfaceTint = surfaceBrightDark,
    outlineVariant = outlineVariantDark,
    scrim = scrimDark,
)

@Composable
fun MyApplicationTheme(
    content: @Composable () -> Unit
) {
    val settings = LocalSettingsProvider.current

    DynamicTheme(
        state = rememberDynamicThemeState(
            getAppColorTuple(
                defaultColorTuple = settings.colorTuple,
                dynamicColor = settings.useDynamicColor,
                darkTheme = settings.isDarkMode,
            )
        ),
        defaultColorTuple = settings.colorTuple,
        isDarkTheme = settings.isDarkMode,
        dynamicColor = settings.useDynamicColor,
        amoledMode = settings.amoledMode
    ) {
        content()
    }
}