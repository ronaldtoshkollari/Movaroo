package com.ronalad.mavaroo.network.repository

import com.ronalad.mavaroo.popular_movies.domain.model.PopularMovie
import com.ronalad.mavaroo.title_details.domain.model.TitleDetails
import com.ronalad.mavaroo.utils.NetworkState

interface IMBDbRepo {
    suspend fun getPopularMovies(): NetworkState<List<PopularMovie>>
    suspend fun getTitleDetails(id: String): NetworkState<TitleDetails>
}