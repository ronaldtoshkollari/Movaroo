package com.ronalad.mavaroo.domain.use_cases

import com.ronalad.mavaroo.domain.model.PopularMovie
import com.ronalad.mavaroo.domain.repository.IMBDbRepo
import com.ronalad.mavaroo.utils.Constants.DEFAULT_MESSAGE
import com.ronalad.mavaroo.utils.NetworkState
import com.ronalad.mavaroo.utils.UiState
import javax.inject.Inject

class GetPopularMoviesUseCase @Inject constructor(
    private val repo: IMBDbRepo
) {

    suspend operator fun invoke() : UiState<List<PopularMovie>> {
        return try {
            when (val result = repo.getPopularMovies()) {
                is NetworkState.Success -> {
                    UiState.Success(data = result.data ?: emptyList())
                }

                else -> {
                    UiState.Error(message = result.message ?: DEFAULT_MESSAGE)
                }
            }
        } catch (error: Exception) {
            UiState.Error(message = error.message ?: DEFAULT_MESSAGE)
        }
    }

}