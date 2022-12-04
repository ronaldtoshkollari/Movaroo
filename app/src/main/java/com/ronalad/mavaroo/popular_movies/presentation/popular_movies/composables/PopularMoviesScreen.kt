package com.ronalad.mavaroo.popular_movies.presentation.popular_movies.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ronalad.mavaroo.navigation.MavarooScreens
import com.ronalad.mavaroo.popular_movies.presentation.popular_movies.viewmodel.PopularMoviesViewModel
import com.ronalad.mavaroo.ui.theme.ChineseBlack

@Composable
fun PopularMoviesScreen(
    navController: NavController,
    popularMoviesViewModel: PopularMoviesViewModel = hiltViewModel()
) {

    val popularMoviesState by popularMoviesViewModel.popularMoviesState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = ChineseBlack),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        if (popularMoviesState.isLoading) {
            CircularProgressIndicator()
        }

        if(popularMoviesState.popularMovies.isNotEmpty()) {
            MoviesList(movies = popularMoviesState.popularMovies) { id ->
                navController.navigate(MavarooScreens.TitleDetailsScreen.route + "/$id")
            }
        }

        if(popularMoviesState.errorMessage.isNotEmpty()) {
            Text(text = popularMoviesState.errorMessage)
        }

    }

}