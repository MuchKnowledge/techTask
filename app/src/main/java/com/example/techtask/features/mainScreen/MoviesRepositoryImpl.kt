package com.example.techtask.features.mainScreen

import com.example.techtask.features.network.MoviesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor() : MoviesRepository {

    @Inject lateinit var moviesApi: MoviesApi

    override suspend fun loadMovies(): List<MovieData> {
        return withContext(Dispatchers.IO) {
            moviesApi.loadMovie().map {
                it.toItem()
            }
        }
    }
}