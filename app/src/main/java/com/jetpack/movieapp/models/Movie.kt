package com.jetpack.movieapp.models

import android.content.Context
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.google.gson.reflect.TypeToken

data class Movie(
    @SerializedName("imdbID")
    val id: String,
    @SerializedName("Title")
    val title: String,
    @SerializedName("Year")
    val year: String,
    @SerializedName("Genre")
    val genre: String,
    @SerializedName("Director")
    val director: String,
    @SerializedName("Actors")
    val actors: String,
    @SerializedName("Plot")
    val plot: String,
    @SerializedName("Poster")
    val poster: String,
    @SerializedName("Images")
    val images: List<String>,
    @SerializedName("imdbRating")
    val rating: String
) {

    fun getMovies(context: Context): List<Movie> {
        val fileData: String? = context.assets?.open("films.json")?.readBytes()?.let { String(it) }
        val moviesListType = object : TypeToken<List<Movie>>() {}.type
        return Gson().fromJson(fileData, moviesListType)
    }

}


