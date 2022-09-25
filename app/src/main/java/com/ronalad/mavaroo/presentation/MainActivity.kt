package com.ronalad.mavaroo.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ronalad.mavaroo.presentation.popular_movies.composables.MoviesList
import com.ronalad.mavaroo.presentation.popular_movies.composables.PopularMoviesScreen
import com.ronalad.mavaroo.presentation.popular_movies.viewmodel.PopularMoviesViewModel
import com.ronalad.mavaroo.presentation.ui.theme.MovarooTheme
import com.ronalad.mavaroo.utils.UiState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: PopularMoviesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MovarooTheme {
                val popularMoviesState = viewModel.popularMoviesState.collectAsState()
                PopularMoviesScreen(
                    popularMovies = popularMoviesState.value.popularMovies,
                    isLoading = popularMoviesState.value.isLoading,
                    errorMessage = popularMoviesState.value.errorMessage
                )
            }
        }
    }
}
