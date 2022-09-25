package com.ronalad.mavaroo.presentation.popular_movies.viewmodel

import com.ronalad.mavaroo.domain.model.PopularMovie

data class PopularMoviesState(
    val popularMovies: List<PopularMovie> = emptyList(),
    val isLoading: Boolean = true,
    val errorMessage: String = ""
)