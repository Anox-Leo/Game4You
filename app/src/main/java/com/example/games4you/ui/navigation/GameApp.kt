package com.example.games4you.ui.navigation

import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.games4you.ui.screens.GameListScreen
import com.example.games4you.ui.screens.GameDetailScreen
import com.example.games4you.ui.screens.GameSearchScreen
import com.example.games4you.ui.viewmodels.GameViewModel

@Composable
fun GameApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    val gameViewModel: GameViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = "gameList"
    ) {
        composable(
            route = "gameList",
            enterTransition = {
                slideInHorizontally { fullWidth -> fullWidth } + fadeIn()
            },
            exitTransition = {
                slideOutHorizontally { fullWidth -> -fullWidth } + fadeOut()
            },
            popEnterTransition = {
                slideInHorizontally { fullWidth -> -fullWidth } + fadeIn()
            },
            popExitTransition = {
                slideOutHorizontally { fullWidth -> fullWidth } + fadeOut()
            }) {
            GameListScreen(
                modifier = modifier,
                navController = navController,
                gameViewModel = gameViewModel
            )
        }

        composable(
            route = "gameDetail",
            enterTransition = {
                slideInHorizontally { fullWidth -> fullWidth } + fadeIn()
            },
            exitTransition = {
                slideOutHorizontally { fullWidth -> -fullWidth } + fadeOut()
            },
            popEnterTransition = {
                slideInHorizontally { fullWidth -> -fullWidth } + fadeIn()
            },
            popExitTransition = {
                slideOutHorizontally { fullWidth -> fullWidth } + fadeOut()
            }
        ) {
            GameDetailScreen(
                navController = navController,
                modifier = modifier,
                gameViewModel = gameViewModel
            )
        }

        composable(
            route = "gameSearch",
            enterTransition = {
                slideInHorizontally { fullWidth -> fullWidth } + fadeIn()
            },
            exitTransition = {
                slideOutHorizontally { fullWidth -> -fullWidth } + fadeOut()
            },
            popEnterTransition = {
                slideInHorizontally { fullWidth -> -fullWidth } + fadeIn()
            },
            popExitTransition = {
                slideOutHorizontally { fullWidth -> fullWidth } + fadeOut()
            }
        ) {
            GameSearchScreen(
                modifier = modifier,
                navController = navController
            ) { query ->
                gameViewModel.setSearchQuery(query)
            }
        }
    }
}
