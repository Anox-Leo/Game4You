package com.example.games4you.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle

@Composable
fun Platforms(
    platform: String,
    modifier: Modifier,
    textStyle: TextStyle
) {
    Row {
        val platforms = platform.split(", ")
        platforms.forEach {
            var text = it
            if (it.startsWith("PC")) {
                text = "Windows"
            }
            Badge(text = text, modifier, textStyle)
        }
    }
}