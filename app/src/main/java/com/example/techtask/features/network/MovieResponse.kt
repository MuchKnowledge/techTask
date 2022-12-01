package com.example.techtask.features.network

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("file_url") val fileUrl: String?,
    @SerializedName("small_thumbnail_url") val smallThumbnailUrl: String?,
)