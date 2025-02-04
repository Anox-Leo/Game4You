package com.example.games4you.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.games4you.data.model.Game

@Composable
fun GameList(
    modifier: Modifier = Modifier,
    games: List<Game>,
    onGameClick: (gameId: Int) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 150.dp),
        contentPadding = PaddingValues(6.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(games) { game ->
            GameCard(
                title = game.title,
                platform = game.platform,
                genre = game.genre,
                thumbnail = game.thumbnail,
                releaseDate = game.releaseDate,
                modifier = modifier
                    .size(width = 160.dp, height = 200.dp)
                    .clickable{
                        onGameClick(game.id)
                    }
            )
            Spacer(modifier = Modifier.height(4.dp)) // Espacement entre les cartes
        }
    }
}
