package com.example.techtask.features.mainScreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val loadMoviesUseCase: LoadMoviesUseCase,
) : ViewModel() {

    val state: MutableLiveData<MainScreenState> = MutableLiveData(MainScreenState.Init)

    fun onMovieClick(movieUrl: String) {
        viewModelScope.launch {
            state.value = MainScreenState.PlayMovie(movieUrl)
        }
    }

    fun onInit() {
        viewModelScope.launch {
            state.value = MainScreenState.Loading
            state.value = MainScreenState.MoviesLoaded(loadMoviesUseCase.loadMovies())
            state.value = MainScreenState.PlayMovie(loadMoviesUseCase.loadMovies().first().fileUrl)
        }
    }
}