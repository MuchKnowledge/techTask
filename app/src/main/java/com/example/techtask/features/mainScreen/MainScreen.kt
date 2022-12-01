package com.example.techtask.features.mainScreen

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import com.example.app.utils.quickInit
import com.example.techtask.R
import com.example.techtask.base.viewBinding
import com.example.techtask.databinding.ActivityMainBinding
import com.example.techtask.databinding.MovieItemBinding
import com.example.techtask.di.DaggerAppComponent
import com.example.techtask.utils.ext.gone
import com.example.techtask.utils.ext.loadWithGlide
import com.example.techtask.utils.ext.roundCorners
import com.example.techtask.utils.ext.visible

class MainScreen : AppCompatActivity() {

    private val binding: ActivityMainBinding by viewBinding()
    private val viewModel = DaggerAppComponent.create().getMainViewModel()

    private lateinit var exoPlayer: ExoPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initExoplayer()
        observeState()
        supportActionBar?.hide()
    }

    private fun initExoplayer() {
        exoPlayer = ExoPlayer.Builder(this).build()
        with(exoPlayer) {
            binding.exoplayer.player.player = exoPlayer
            repeatMode = Player.REPEAT_MODE_ONE
            prepare()
        }
    }

    private fun observeState() {
        viewModel.state.observe(this) {
            when (it) {
                MainScreenState.Init -> viewModel.onInit()
                MainScreenState.Loading -> showLoadingState()
                is MainScreenState.MoviesLoaded -> showLoadedState(it.movies)
                is MainScreenState.PlayMovie -> playMovie(it.playingMovieUrl)
            }
        }
    }

    private fun showLoadingState() {
        with(binding) {
            progress.visible()
            constraintContent.gone()
        }
    }

    private fun showLoadedState(movies: List<MovieData>) {
        with(binding) {
            recyclerMovies.quickInit(
                items = movies,
                itemLayout = R.layout.movie_item,
                bind = { item, _ -> bindMovieItem(this, item.fileUrl) }
            )
            exoplayer.root.roundCorners(radius = 16f)
            inputLayout.background = null
            progress.gone()
            constraintContent.visible()
        }
    }

    private fun bindMovieItem(view: View, url: String) {
        with(MovieItemBinding.bind(view)) {
            imagePoster.loadWithGlide(url)
            imagePoster.roundCorners(radius = 16f)
            root.setOnClickListener { onRecyclerItemClick(url) }
        }
    }

    private fun onRecyclerItemClick(movieUrl: String) {
        viewModel.onMovieClick(movieUrl)
    }

    private fun playMovie(movieUrl: String) {
        val mediaItem = MediaItem.fromUri((movieUrl.toUri()))
        with(exoPlayer) {
            setMediaItem(mediaItem)
            prepare()
            play()
        }
    }
}