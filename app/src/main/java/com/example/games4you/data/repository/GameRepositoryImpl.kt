package com.example.games4you.data.repository

import com.example.games4you.data.model.Game
import com.example.games4you.data.api.GameApiService
import com.example.games4you.data.api.dto.toGame
import com.example.games4you.domain.repository.GameRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GameRepositoryImpl(

    private val apiService: GameApiService,
    
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
    
) : GameRepository {
    
    override fun getAllGames(): Flow<List<Game>> {
        return flow {
            emit(apiService.getAllGames().map { it.toGame() })
        }.flowOn(dispatcher)
    }

    override fun getAllGamesSorted(sortName: String): Flow<List<Game>> {
        return flow {
            emit(apiService.getAllGamesSorted(sortName).map { it.toGame() })
        }.flowOn(dispatcher)
    }

    override fun getGameById(gameId: Int): Flow<Game?> {
        return flow {
            emit(apiService.getGameById(gameId).toGame())
        }.flowOn(dispatcher)
    }
}