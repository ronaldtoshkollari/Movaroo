package com.ronalad.mavaroo.presentation.popular_movies.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.ronalad.mavaroo.domain.model.PopularMovie

@Composable
fun PopularMoviesScreen(
    popularMovies: List<PopularMovie>,
    isLoading: Boolean,
    errorMessage: String
) {

    Column(
        modifier = Modifier.fillMaxSize().background(color = Color(0xFF121420)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        if (isLoading) {
            CircularProgressIndicator()
        }

        if(popularMovies.isNotEmpty()) {
            MoviesList(movies = popularMovies)
        }

        if(errorMessage.isNotEmpty()) {
            Text(text = errorMessage)
        }

    }

}