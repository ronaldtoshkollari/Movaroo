package com.ronalad.mavaroo.popular_movies.data.remote.dto

import com.google.gson.annotations.SerializedName

data class PopularMoviesListDto(
    @SerializedName("items")
    private val _items: List<PopularMovieDto>? = emptyList(),
    @SerializedName("errorMessage")
    private val _errorMessage: String? = ""
) {
    val items: List<PopularMovieDto>
        get() = _items ?: emptyList()

    val errorMessage: String
        get() = _errorMessage ?: ""
}
