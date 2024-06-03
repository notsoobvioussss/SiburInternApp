package com.example.myapplication.presentation.screen.characters

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.myapplication.domain.model.Character
import com.example.myapplication.presentation.util.ui.other.LocalSettingsProvider
import com.example.myapplication.presentation.util.ui.widgets.CharacterCard

@Composable
fun CharacterItem(
    character: Character,
    onClick: (c: Character) -> Unit) {
    val settings = LocalSettingsProvider.current
    val colorScheme = settings.getColorScheme()

    CharacterCard(
        title = character.name,
        description = { modifier ->
            Column(modifier) {
                Text("Status: ${character.status}")
                Text("Gender: ${character.gender}")
                Text("Episodes: ${character.episode.size}")
            }
        },
        borderEnabled = settings.bordersEnabled,
        borderColor = colorScheme.outline,
        imageURL = character.image,
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick(character) }
    )
}