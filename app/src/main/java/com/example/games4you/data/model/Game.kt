package com.example.games4you.data.model

data class Game(
    val id : Int,
    val title: String,
    val genre: String,
    val platform: String,
    val publisher: String,
    val developer: String,
    val description: String? = "",
    val releaseDate: String,
    val thumbnail: String,
    val screenshots: List<Image>? = null,
    val requirements: Requirements? = null
)

data class Image(
    val id: Int,
    val image: String
)

data class Requirements(
    val os: String,
    val processor: String,
    val memory: String,
    val graphics: String,
    val storage: String
)
