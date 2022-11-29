package com.example.techtask.features.mainScreen

interface MoviesRepository {
    suspend fun loadMovies(): List<MovieData>
}