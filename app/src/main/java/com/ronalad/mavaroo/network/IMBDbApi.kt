package com.ronalad.mavaroo.network

import com.ronalad.mavaroo.popular_movies.data.remote.dto.PopularMoviesListDto
import com.ronalad.mavaroo.title_details.data.dto.TitleDetailsDto
import com.ronalad.mavaroo.utils.Constants.KEY
import retrofit2.http.GET
import retrofit2.http.Path

interface IMBDbApi {

    companion object {
        const val POPULAR_MOVIES = "MostPopularMovies"
        const val TITLE = "Title"
    }

    @GET("/en/API/$POPULAR_MOVIES/${KEY}")
    suspend fun getPopularMovies() : PopularMoviesListDto?

    @GET("/en/API/$TITLE/${KEY}/{id}")
    suspend fun getTitleDetails(
        @Path("id") id: String
    ) : TitleDetailsDto?

}