package com.example.games4you.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object GameClient {
    private const val API_URL = "https://www.freetogame.com/"

    fun create(): GameApiService {
        return Retrofit.Builder()
            .baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GameApiService::class.java)
    }
}