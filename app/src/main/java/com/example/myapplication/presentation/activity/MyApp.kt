package com.example.myapplication.presentation.activity

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.presentation.screen.characters.CharacterListScreen
import com.example.myapplication.presentation.screen.profilescreen.SettingsScreen
import com.example.myapplication.presentation.util.other.Screen
import com.example.myapplication.presentation.util.other.rememberAppBarState
import com.example.myapplication.presentation.util.ui.other.LocalSettingsProvider
import com.example.myapplication.presentation.util.ui.theme.MyApplicationTheme
import com.example.myapplication.presentation.util.ui.widgets.TopAppBar
import com.gigamole.composeshadowsplus.softlayer.softLayerShadow
import dev.olshevski.navigation.reimagined.NavBackHandler
import dev.olshevski.navigation.reimagined.NavHost
import dev.olshevski.navigation.reimagined.navigate
import dev.olshevski.navigation.reimagined.popAll
import dev.olshevski.navigation.reimagined.rememberNavController

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun MyApp(
    viewModel: MainViewModel
) {
    val navController = rememberNavController(startDestination = viewModel.currentScreen)

    val settings = LocalSettingsProvider.current
    val colorScheme = settings.getColorScheme()

    val screens = listOf(
        Screen.Catalog,
        Screen.Settings
    )

    val isBottomBarVisible: MutableState<Boolean> = remember { mutableStateOf(true) }

    val topAppBarState = rememberAppBarState(
        borderEnabled = settings.bordersEnabled
    )

    MyApplicationTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    modifier = Modifier,
                    topAppBarState = topAppBarState,
                    outlineColor = colorScheme.outline
                )
            },
            bottomBar = {
                AnimatedVisibility(visible = isBottomBarVisible.value, exit = ExitTransition.None, enter = EnterTransition.None) {
                    BottomAppBar(if (settings.bordersEnabled) {
                        Modifier.drawWithContent {
                            drawContent()
                            drawRect(
                                colorScheme.outline,
                                topLeft = Offset(0f, 0f),
                                size = Size(this.size.width, density)
                            )
                        }
                    } else {
                        Modifier.softLayerShadow(spread = 2.dp, offset = DpOffset(2.dp, 0.dp))
                    }) {
                        screens.forEach { screen ->
                            val title = when (screen) {
                                Screen.Settings -> stringResource(R.string.settings)
                                else -> stringResource(R.string.list)
                            }
                            NavigationBarItem(
                                selected = viewModel.currentScreen == screen,
                                onClick = {
                                    viewModel.updateCurrentScreen(screen)
                                    navController.popAll()
                                    navController.navigate(screen)
                                },
                                icon = {
                                    Icon(
                                        imageVector = when (screen) {
                                            Screen.Settings -> Icons.Outlined.Settings
                                            else -> Icons.Outlined.Star
                                        },
                                        contentDescription = title
                                    )
                                },
                                label = { Text(title) },
                                alwaysShowLabel = false
                            )
                        }
                    }

                }

            }
        ) { innerPaddings ->
            NavBackHandler(navController)
            NavHost(navController) { screen ->
                topAppBarState.current.updateTopAppBar(title = {
                    Text(
                        screen.name,
                        modifier = Modifier.basicMarquee()
                    )
                }, navigationIcon = {})
                when (screen) {
                    Screen.Settings -> SettingsScreen(Modifier.padding(innerPaddings))

                    Screen.Catalog -> {
                        CharacterListScreen(Modifier.padding(innerPaddings)) {
                            isBottomBarVisible.value = !isBottomBarVisible.value
                        }
                    }
                }

            }
        }
    }

    BackHandler(enabled = true) {

    }
}
