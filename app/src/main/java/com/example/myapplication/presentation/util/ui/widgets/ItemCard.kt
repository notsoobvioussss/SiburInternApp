package com.example.myapplication.presentation.util.ui.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ru.tanexc.meal.presentation.util.ui.theme.Typography

@Composable
fun ItemCard(
    modifier: Modifier = Modifier,
    borderWidth: Dp = 1.dp,
    borderRadius: Dp = 16.dp,
    borderColor: Color = Color.Transparent,
    backgroundColor: Color = MaterialTheme.colorScheme.secondary.copy(0.3f),
    title: String,
    content: @Composable () -> Unit

) {
    Box(
        modifier = modifier
            .border(
                width = borderWidth,
                shape = RoundedCornerShape(borderRadius),
                brush = if (borderWidth > 0.dp) SolidColor(borderColor) else SolidColor(Color.Transparent)
            )
            .background(backgroundColor, RoundedCornerShape(borderRadius))
    ) {
        Column(Modifier.padding(16.dp)) {
            Text(text = title, style = Typography.headlineMedium)
            content()
        }

    }
}