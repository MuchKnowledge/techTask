package com.example.techtask.features.mainScreen

sealed class MainScreenState {
    object Init : MainScreenState()
    object Loading : MainScreenState()
    class MoviesLoaded(val movies: List<MovieData>) : MainScreenState()
    class PlayMovie(val playingMovieUrl: String) : MainScreenState()
}
