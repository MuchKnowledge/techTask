package com.example.techtask.utils.ext

import android.view.View
import androidx.core.view.isVisible
import com.example.techtask.utils.base.CornersOutlineProvider
import com.example.techtask.utils.base.RoundCorners

fun View.roundCorners(roundCorners: RoundCorners = RoundCorners.ALL, radius: Float = 4f) {
    outlineProvider = CornersOutlineProvider(roundCorners, radius)
    clipToOutline = true
}

fun View.gone() {
    this.isVisible = false
}

fun View.visible() {
    this.isVisible = true
}