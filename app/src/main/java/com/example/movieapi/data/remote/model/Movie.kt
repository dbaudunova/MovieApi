package com.example.movieapi.data.remote.model

import java.io.Serializable

data class Movie(
    val Country: String,
    val Genre: String,
    val Language: String,
    val Poster: String,
    val Released: String,
    val Runtime: String,
    val Year: String
) :Serializable