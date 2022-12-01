package com.example.techtask.features.mainScreen

import com.example.techtask.features.network.MovieResponse

fun MovieResponse.toItem() = MovieData(
    fileUrl = fileUrl ?: "",
    smallThumbnailUrl = smallThumbnailUrl ?: "",
)