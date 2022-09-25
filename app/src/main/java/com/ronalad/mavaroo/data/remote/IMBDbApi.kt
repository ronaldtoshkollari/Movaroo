package com.ronalad.mavaroo.data.remote

import com.ronalad.mavaroo.data.remote.dto.PopularMoviesListDto
import com.ronalad.mavaroo.utils.Constants.KEY
import retrofit2.http.GET

interface IMBDbApi {

    companion object {
        const val POPULAR_MOVIES = "MostPopularMovies"
    }

    @GET("/en/API/${POPULAR_MOVIES}/${KEY}")
    suspend fun getPopularMovies() : PopularMoviesListDto?

}