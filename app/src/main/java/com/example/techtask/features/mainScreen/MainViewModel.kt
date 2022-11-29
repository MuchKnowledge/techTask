package com.example.techtask.features.mainScreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
) : ViewModel() {

    val state: MutableLiveData<MainScreenState> = MutableLiveData(MainScreenState.Init)
}