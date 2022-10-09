package com.ronalad.mavaroo.popular_movies.domain.model

import com.ronalad.mavaroo.popular_movies.data.remote.dto.PopularMovieDto

data class PopularMovie(
    val id: String = "",
    val rank: Int = -1,
    val rankUpDown: String = "",
    val title: String = "",
    val year: Int = -1,
    val image: String = "",
    val imDbRating: Double = 0.0,
    val imDbRatingCount: Int = -1
) {
    constructor(popularMovieDto: PopularMovieDto) : this(
        id = popularMovieDto.id,
        rank = popularMovieDto.rank,
        rankUpDown = popularMovieDto.rankUpDown,
        title = popularMovieDto.title,
        year = popularMovieDto.year,
        image = popularMovieDto.image,
        imDbRating = popularMovieDto.imDbRating,
        imDbRatingCount = popularMovieDto.imDbRatingCount
    )
}
