package com.example.myapplication.presentation.screen.characters

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.presentation.screen.character.CharacterScreen
import org.koin.androidx.compose.koinViewModel

@Composable
fun CharacterListScreen(
    modifier: Modifier,
    bottomBarVisibility: () -> Unit
) {
    val viewModel: CharacterViewModel = koinViewModel()
    val isLoading by viewModel.isLoading.collectAsState()
    val characters by viewModel.characters.collectAsState()
    val lazyListState = rememberLazyListState()

    LaunchedEffect(true) {
        viewModel.loadCharacters()
    }

    if (viewModel.currentCharacter != null) {
        CharacterScreen(
            modifier = Modifier
                .fillMaxSize(),
            character = viewModel.currentCharacter!!,
            onClose = {
                bottomBarVisibility()
                viewModel.updateCharacter()
            }
        )
    } else {
        Box(
            modifier = modifier
                .fillMaxSize()
        ) {
            if (isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            } else {
                LazyColumn(contentPadding = PaddingValues(16.dp), state = lazyListState) {
                    items(characters) { item ->
                        CharacterItem(item) {
                            bottomBarVisibility()
                            viewModel.updateCharacter(it)
                        }
                    }

                    item {
                        LaunchedEffect(true) {
                            if (lazyListState.firstVisibleItemIndex != 1) {
                                viewModel.getNextPage()
                            }
                        }
                    }
                }
            }
        }
    }


}