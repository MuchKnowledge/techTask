package com.example.techtask.features.mainScreen

import com.example.techtask.di.DaggerAppComponent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor() : MoviesRepository {

    private val moviesApi = DaggerAppComponent.create().getMovieApi()

    override suspend fun loadMovies(): List<MovieData> {
        return withContext(Dispatchers.IO) {
            moviesApi.loadMovie().map {
                it.toItem()
            }
        }
    }
}