package com.ronalad.mavaroo.popular_movies.presentation.popular_movies.viewmodel

import com.ronalad.mavaroo.popular_movies.domain.model.PopularMovie

data class PopularMoviesState(
    val popularMovies: List<PopularMovie> = emptyList(),
    val isLoading: Boolean = true,
    val errorMessage: String = ""
)