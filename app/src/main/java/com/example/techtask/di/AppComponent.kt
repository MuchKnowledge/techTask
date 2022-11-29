package com.example.techtask.di

import com.example.techtask.features.mainScreen.MainViewModel
import com.example.techtask.features.mainScreen.MoviesRepositoryImpl
import dagger.Subcomponent
import javax.inject.Singleton

@Singleton
@Subcomponent(modules = [NetworkModule::class, RepositoryModule::class])
interface AppComponent {

    fun getMainViewModel(): MainViewModel
    fun getMoviesRepository(): MoviesRepositoryImpl
}