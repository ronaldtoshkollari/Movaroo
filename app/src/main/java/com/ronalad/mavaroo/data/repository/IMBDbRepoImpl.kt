package com.ronalad.mavaroo.data.repository

import com.ronalad.mavaroo.data.remote.IMBDbApi
import com.ronalad.mavaroo.domain.model.PopularMovie
import com.ronalad.mavaroo.domain.repository.IMBDbRepo
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

}