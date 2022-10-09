package com.ronalad.mavaroo.popular_movies.presentation.popular_movies.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.ronalad.mavaroo.popular_movies.domain.model.PopularMovie
import com.ronalad.mavaroo.ui.theme.ChineseBlack

@Composable
fun PopularMoviesScreen(
    popularMovies: List<PopularMovie>,
    isLoading: Boolean,
    errorMessage: String
) {

    Column(
        modifier = Modifier.fillMaxSize().background(color = ChineseBlack),
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