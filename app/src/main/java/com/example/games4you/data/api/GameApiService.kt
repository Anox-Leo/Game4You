package com.example.games4you.data.api

import com.example.games4you.data.api.dto.GameDto
import retrofit2.http.GET
import retrofit2.http.Query

interface GameApiService {

    @GET("api/games")
    suspend fun getAllGames(): List<GameDto>

    @GET("api/games")
    suspend fun getAllGamesSorted(@Query("sort-by") sortName: String): List<GameDto>

    @GET("api/game")
    suspend fun getGameById(@Query("id") gameId: Int): GameDto

}