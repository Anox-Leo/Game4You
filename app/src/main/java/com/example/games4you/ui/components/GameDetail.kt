package com.example.games4you.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.games4you.data.model.Game
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import com.example.games4you.data.model.Image

@Composable
fun GameDetail(
    navController: NavController,
    modifier: Modifier = Modifier,
    game: Game
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        ArrowBack(navController = navController)
        AsyncImage(
            model = game.thumbnail,
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(8.dp))
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = game.title,
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextRow(label = "Développement", value = game.developer)
        TextRow(label = "Edition", value = game.publisher)
        TextRow(label = "Sorti le", value = game.releaseDate)
        TextRow(label = "Genre", value = game.genre)

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = game.description?: "",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Screenshots: ",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 4.dp)
        )


        var selectedImage by remember {
            mutableStateOf(game.screenshots?.get(0)?.image)
        }

        selectedImage?.let { imageUrl ->
            LargeImage(imageUrl)
        }

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
        ) {
            val screenshots: List<Image> = game.screenshots!!
            items(screenshots) { screenshot ->
                println(screenshot.image)
                AsyncImage(
                    model = screenshot.image,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(end = 4.dp)
                        .width(120.dp)
                        .clip(RoundedCornerShape(2.dp))
                        .clickable { selectedImage = screenshot.image }
                )
            }
        }

        Text(
            text = "Plateformes: ",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 4.dp)
        )

        Platforms(game.platform, modifier = Modifier
            .padding(bottom = 4.dp, top = 4.dp, end = 8.dp)
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = RoundedCornerShape(16.dp)
            ),
            textStyle = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Configuration requise: ",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 4.dp)
        )

        TextRow(label = "OS", value = game.requirements?.os ?: "Non spécifié")
        TextRow(label = "Processeur", value = game.requirements?.processor ?: "Non spécifié")
        TextRow(label = "Mémoire", value = game.requirements?.memory ?: "Non spécifié")
        TextRow(label = "Graphiques", value = game.requirements?.graphics ?: "Non spécifié")
        TextRow(label = "Espace disque", value = game.requirements?.storage ?: "Non spécifié")

    }
}

@Composable
fun TextRow(label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "$label:",
            color = Color.Gray,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.weight(0.5f)
        )
        Text(
            text = value,
            color = MaterialTheme.colorScheme.tertiary,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun LargeImage(selectedImage: String) {
    AsyncImage(
        model = selectedImage,
        contentDescription = null,
        contentScale = ContentScale.Fit,
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
            .clip(RoundedCornerShape(8.dp))
            .padding(bottom = 16.dp)
    )
}
