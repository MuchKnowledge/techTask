package com.example.techtask.di

import com.example.techtask.features.mainScreen.MainViewModel
import com.example.techtask.features.mainScreen.MoviesRepositoryImpl
import com.example.techtask.features.network.MoviesApi
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, RepositoryModule::class])
interface AppComponent {

    fun getMainViewModel(): MainViewModel
    fun getMoviesRepository(): MoviesRepositoryImpl
    fun getMovieApi(): MoviesApi
}