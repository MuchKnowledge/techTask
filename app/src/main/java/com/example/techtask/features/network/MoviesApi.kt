package com.example.techtask.features.network

import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {

    @GET("/api/backgrounds/")
    suspend fun loadMovie(
        @Query("group") group: String = "video",
        @Query("category_id") page: Int = 1,
    ): List<MovieResponse>
}