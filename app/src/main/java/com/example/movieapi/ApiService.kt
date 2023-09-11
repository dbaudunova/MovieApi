package com.example.movieapi

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(".")
    fun getMovie(
        @Query("apikey") key: String,
        @Query("t") name: String,
    ): Call<Movie>
}