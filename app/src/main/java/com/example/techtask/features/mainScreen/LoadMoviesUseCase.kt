package com.example.techtask.features.mainScreen

import javax.inject.Inject

class LoadMoviesUseCase @Inject constructor() {

    @Inject lateinit var repository: MoviesRepository

    suspend fun loadMovies(): List<MovieData> {
        return repository.loadMovies()
    }
}