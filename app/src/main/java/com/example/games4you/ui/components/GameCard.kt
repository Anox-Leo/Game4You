package com.example.games4you.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun GameCard(
    modifier: Modifier = Modifier,
    title: String,
    platform: String,
    genre: String,
    releaseDate: String,
    thumbnail: String
) {
    Column(
        modifier = modifier
            .padding(8.dp)
            .background(color = MaterialTheme.colorScheme.primary, shape = RoundedCornerShape(8.dp))
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            AsyncImage(
                model = thumbnail,
                contentDescription = "Game thumbnail",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp))
            )

        }

        Spacer(modifier = Modifier.height(4.dp))

        Column(modifier = Modifier.padding(horizontal = 8.dp)) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.Bold
            )

            Text(text = "$genre | $releaseDate", style = MaterialTheme.typography.bodySmall)

            Spacer(modifier = Modifier.height(6.dp))
            Platforms(platform, modifier = Modifier
                .padding(bottom = 2.dp, top = 2.dp, end = 4.dp)
                .background(
                    color = MaterialTheme.colorScheme.surface,
                    shape = RoundedCornerShape(16.dp)
                ),
                textStyle = MaterialTheme.typography.labelSmall
            )
        }
    }
}
