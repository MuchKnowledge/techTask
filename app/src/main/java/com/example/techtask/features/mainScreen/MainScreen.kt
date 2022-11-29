package com.example.techtask.features.mainScreen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.techtask.R
import javax.inject.Inject

class MainScreen : AppCompatActivity() {

    @Inject lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}