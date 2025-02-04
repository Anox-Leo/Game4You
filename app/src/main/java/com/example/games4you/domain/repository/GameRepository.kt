package com.example.games4you.domain.repository

import com.example.games4you.data.model.Game
import kotlinx.coroutines.flow.Flow

interface GameRepository {

    fun getAllGames(): Flow<List<Game>>
    fun getAllGamesSorted(sortName: String): Flow<List<Game>>
    fun getGameById(gameId: Int): Flow<Game?>

}