package com.example.games4you.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.games4you.ui.components.ArrowBack
import com.example.games4you.ui.components.SearchBar

@Composable
fun GameSearchScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    onSearch: (String) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ){
            ArrowBack(navController = navController)
            Text(
                text = "Recherche de jeux",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }

        SearchBar(
            onSearch = onSearch,
            navController = navController
        )
    }
}