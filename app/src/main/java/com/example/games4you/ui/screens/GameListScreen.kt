package com.example.games4you.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Sort
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.games4you.ui.components.GameList
import com.example.games4you.ui.components.SearchButton
import com.example.games4you.ui.viewmodels.GameViewModel

@Composable
fun GameListScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    gameViewModel: GameViewModel
) {
    val games by gameViewModel.games.collectAsStateWithLifecycle()
    val searchQuery by gameViewModel.searchQuery.collectAsStateWithLifecycle()
    var isExpanded by remember { mutableStateOf(false) }

    val filteredGames = games.filter {
        it.title.contains(searchQuery, ignoreCase = true) ||
                it.genre.contains(searchQuery, ignoreCase = true)
    }

    if (games.isEmpty()) {
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

    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Column {
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Game4You",
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier.padding(start = 16.dp),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                )
                SearchButton(
                    searchQuery = searchQuery,
                    navController = navController,
                    gameViewModel = gameViewModel
                )
            }

            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Bibliothèque de jeux : ",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp
            )

            GameList(
                games = filteredGames, // Use the filtered list
                onGameClick = { gameId ->
                    gameViewModel.selectGame(gameId)
                    navController.navigate("gameDetail")
                }
            )
        }

        Column(
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
        ) {
            if (isExpanded) {
                GameViewModel.SortMode.entries.forEach { mode ->
                    FloatingActionButton(
                        onClick = {
                            gameViewModel.sortData(mode)
                            isExpanded = false
                        },
                        modifier = Modifier.size(56.dp),
                        containerColor = MaterialTheme.colorScheme.surface,
                        contentColor = Color.White
                    ) {
                        Text(
                            text = mode.display
                        )
                    }
                }
            }

            FloatingActionButton(
                onClick = { isExpanded = !isExpanded },
                modifier = Modifier.size(64.dp),
                containerColor = MaterialTheme.colorScheme.surface,
                contentColor = Color.White
            ) {
                Icon(
                    imageVector = if (isExpanded) Icons.Default.Close else Icons.AutoMirrored.Filled.Sort,
                    contentDescription = if (isExpanded) "Fermer" else "Trier"
                )
            }
        }
    }
}