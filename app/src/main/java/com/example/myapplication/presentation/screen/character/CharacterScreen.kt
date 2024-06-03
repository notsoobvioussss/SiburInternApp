package com.example.myapplication.presentation.screen.character

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.outlined.UnfoldLess
import androidx.compose.material.icons.outlined.UnfoldMore
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.domain.model.Character
import com.example.myapplication.presentation.util.other.rememberAppBarState
import com.example.myapplication.presentation.util.ui.other.LocalSettingsProvider
import com.example.myapplication.presentation.util.ui.widgets.ItemCard
import com.example.myapplication.presentation.util.ui.widgets.Picture
import com.example.myapplication.presentation.util.ui.widgets.TopAppBar

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun CharacterScreen(
    modifier: Modifier,
    character: Character,
    onClose: () -> Unit
) {

    val settings = LocalSettingsProvider.current
    val colorScheme = settings.getColorScheme()

    val isImageCollapsed = remember { mutableStateOf(false) }

    val borderWidth = 1.dp * (if (settings.bordersEnabled) 1 else 0)

    val topAppBarState = rememberAppBarState(
        borderEnabled = settings.bordersEnabled,
        navigationIcon = {
            IconButton(onClick = onClose) {
                Icon(Icons.AutoMirrored.Outlined.ArrowBack, null)
            }
        },
        title = {
            Text(character.name, Modifier.basicMarquee())
        }
    )

    Column(modifier) {
        TopAppBar(
            modifier = Modifier,
            topAppBarState = topAppBarState,
            outlineColor = colorScheme.outline,
        )
        LazyColumn(
            Modifier.padding(8.dp, 0.dp)
        ) {
            item {
                Spacer(Modifier.size(16.dp))
                AnimatedContent(
                    targetState = isImageCollapsed,
                    label = ""
                ) { targetState ->
                    Box(
                        modifier = Modifier
                            .wrapContentHeight()
                            .fillMaxWidth()
                    ) {
                        Picture(
                            modifier = if (!targetState.value) {
                                Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(16.dp))
                            } else {
                                Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(16.dp))
                                    .height(256.dp)
                            }
                                .border(
                                    width = borderWidth,
                                    shape = RoundedCornerShape(16.dp),
                                    brush =
                                    if (borderWidth > 0.dp) SolidColor(colorScheme.outline)
                                    else SolidColor(Color.Transparent)
                                ),
                            imageURL = character.image,
                            contentDescription = "",
                            imageCache = null
                        )
                        FilledIconButton(
                            onClick = { isImageCollapsed.value = !isImageCollapsed.value },
                            modifier = Modifier
                                .size(48.dp)
                                .align(Alignment.TopEnd)
                                .padding(10.dp)
                        ) {
                            if (isImageCollapsed.value) {
                                Icon(
                                    Icons.Outlined.UnfoldMore,
                                    contentDescription = null,
                                    modifier = Modifier.padding(2.dp)
                                )
                            } else {
                                Icon(
                                    Icons.Outlined.UnfoldLess,
                                    contentDescription = null,
                                    modifier = Modifier.padding(2.dp)
                                )
                            }
                        }

                    }
                }
                Spacer(Modifier.size(4.dp))
            }


            item {

                Row(
                    Modifier
                        .padding(0.dp, 4.dp)
                        .height(intrinsicSize = IntrinsicSize.Max)
                ) {

                    ItemCard(
                        modifier = Modifier
                            .fillMaxWidth(),
                        borderWidth = borderWidth,
                        borderColor = colorScheme.outline,
                        backgroundColor = colorScheme.secondaryContainer.copy(0.3f),
                        title = stringResource(R.string.name)
                    ) {
                        Text(character.name)
                    }
                }

            }

            item {
                Row(
                    Modifier
                        .padding(0.dp, 4.dp)
                        .height(intrinsicSize = IntrinsicSize.Max)
                ) {

                    ItemCard(
                        modifier = Modifier
                            .weight(0.5f)
                            .fillMaxHeight(),
                        borderWidth = borderWidth,
                        borderColor = colorScheme.outline,
                        backgroundColor = colorScheme.secondaryContainer.copy(0.3f),
                        title = stringResource(R.string.status)
                    ) {
                        Text(character.status)
                    }
                    Spacer(modifier = Modifier.size(8.dp))
                    ItemCard(
                        modifier = Modifier
                            .weight(0.5f)
                            .fillMaxHeight(),
                        borderWidth = borderWidth,
                        borderColor = colorScheme.outline,
                        backgroundColor = colorScheme.secondaryContainer.copy(0.3f),
                        title = stringResource(R.string.gender)
                    ) {
                        Text(character.gender)
                    }
                }

            }
        }


    }
}