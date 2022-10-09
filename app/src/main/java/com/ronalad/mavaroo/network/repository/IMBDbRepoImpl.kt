package com.ronalad.mavaroo.network.repository

import com.ronalad.mavaroo.network.IMBDbApi
import com.ronalad.mavaroo.popular_movies.domain.model.PopularMovie
import com.ronalad.mavaroo.title_details.domain.model.TitleDetails
import com.ronalad.mavaroo.utils.Constants.DEFAULT_MESSAGE
import com.ronalad.mavaroo.utils.NetworkState
import javax.inject.Inject

class IMBDbRepoImpl @Inject constructor(
    private val imbDbApi: IMBDbApi
) : IMBDbRepo {

    override suspend fun getPopularMovies(): NetworkState<List<PopularMovie>> {
        try {
            val apiResult = imbDbApi.getPopularMovies()
            val errorMessageFromServer = apiResult?.errorMessage ?: ""
            val popularMovies = apiResult?.items?.map { popularMovieDto -> PopularMovie(popularMovieDto) } ?: emptyList()
            if(errorMessageFromServer.isNotEmpty()) return NetworkState.ServerError(message = errorMessageFromServer) // Call was made successfully, but server returned error message
            return NetworkState.Success(data = popularMovies)
        } catch (error: Exception) {
            return NetworkState.Error(message = error.message ?: DEFAULT_MESSAGE)
        }
    }

    override suspend fun getTitleDetails(id: String): NetworkState<TitleDetails> {
        try {
            val apiResult = imbDbApi.getTitleDetails(id = id)
            val errorMessageFromServer = apiResult?.errorMessage ?: ""
            if(errorMessageFromServer.isNotEmpty()) return NetworkState.ServerError(message = errorMessageFromServer)
            if (apiResult == null) return NetworkState.Error(message = DEFAULT_MESSAGE)
            return NetworkState.Success(data = TitleDetails(apiResult))
        } catch (error: Exception) {
            return NetworkState.Error(message = error.message ?: DEFAULT_MESSAGE)
        }
    }
}