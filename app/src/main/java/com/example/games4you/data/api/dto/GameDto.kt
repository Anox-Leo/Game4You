package com.example.games4you.data.api.dto

import com.example.games4you.data.model.Game
import com.example.games4you.data.model.Image
import com.example.games4you.data.model.Requirements
import com.google.gson.annotations.SerializedName

data class GameDto(
    @SerializedName("id") val id : Int,
    @SerializedName("title") val title: String,
    @SerializedName("genre") val genre: String,
    @SerializedName("platform") val platform: String,
    @SerializedName("publisher") val director: String,
    @SerializedName("developer") val developer: String,
    @SerializedName("description") val description: String?,
    @SerializedName("release_date") val releaseDate: String,
    @SerializedName("thumbnail") val thumbnail: String,
    @SerializedName("screenshots") val screenshots: List<Image>?,
    @SerializedName("minimum_system_requirements") val requirements: Requirements?
)

fun GameDto.toGame() : Game {
    return Game(
        id = id,
        title = title,
        genre = genre,
        platform = platform,
        publisher = director,
        developer = developer,
        description = description,
        releaseDate = releaseDate,
        thumbnail = thumbnail,
        screenshots = screenshots,
        requirements = requirements
    )
}
