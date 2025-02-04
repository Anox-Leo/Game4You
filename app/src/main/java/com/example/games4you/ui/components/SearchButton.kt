package com.example.games4you.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.games4you.ui.viewmodels.GameViewModel

@Composable
fun SearchButton(
    searchQuery: String,
    navController: NavController,
    gameViewModel: GameViewModel
) {
    Row {
        IconButton(
            onClick = {
                gameViewModel.clearSearchQuery()
            },
            enabled = searchQuery != "",
        ) {
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = "Clear search",
                tint = if (searchQuery != "") Color.White else MaterialTheme.colorScheme.background                        )
        }
        IconButton(
            onClick = {
                navController.navigate("gameSearch")
            },
            modifier = Modifier.padding(end = 16.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search",
                tint = Color.White
            )
        }
    }
}