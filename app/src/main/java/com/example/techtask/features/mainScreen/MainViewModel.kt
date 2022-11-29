package com.example.techtask.features.mainScreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val repository: MoviesRepository,
) : ViewModel() {

    val state: MutableLiveData<MainScreenState> = MutableLiveData(MainScreenState.Init)
}