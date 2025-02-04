package com.example.games4you.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.games4you.ui.components.GameDetail
import com.example.games4you.ui.viewmodels.GameViewModel

@Composable
fun GameDetailScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    gameViewModel: GameViewModel,
) {

    val game by gameViewModel.selectedGame.collectAsStateWithLifecycle()

    if (game == null) {
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(
                modifier = Modifier.width(64.dp),
                color = MaterialTheme.colorScheme.background,
                trackColor = MaterialTheme.colorScheme.surfaceVariant,
            )
        }
        return
    }

    GameDetail(
        navController = navController,
        modifier = modifier,
        game = game!!
    )
}