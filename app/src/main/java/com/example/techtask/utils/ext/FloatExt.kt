package com.example.techtask.utils.ext

import android.content.res.Resources

val Float.dpToPx: Int get() = (this * Resources.getSystem().displayMetrics.density).toInt()

