package com.ronalad.mavaroo.domain.repository

import com.ronalad.mavaroo.domain.model.PopularMovie
import com.ronalad.mavaroo.utils.NetworkState

interface IMBDbRepo {
    suspend fun getPopularMovies(): NetworkState<List<PopularMovie>>
}