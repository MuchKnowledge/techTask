package com.example.techtask.utils.ext

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.techtask.R

fun ImageView.loadWithGlide(uri: String) {
    Glide.with(this)
        .load(uri)
        .placeholder(R.drawable.image_placeholder)
        .into(this)
}