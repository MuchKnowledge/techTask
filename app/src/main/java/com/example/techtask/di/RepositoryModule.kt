package com.example.techtask.di

import com.example.techtask.features.mainScreen.MoviesRepository
import com.example.techtask.features.mainScreen.MoviesRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object RepositoryModule {

    @Provides
    @Singleton
    fun provideMoviesRepository(): MoviesRepository = MoviesRepositoryImpl()
}