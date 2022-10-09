package com.ronalad.mavaroo.title_details.domain.use_cases

import com.ronalad.mavaroo.network.repository.IMBDbRepo
import com.ronalad.mavaroo.title_details.domain.model.TitleDetails
import com.ronalad.mavaroo.utils.Constants.DEFAULT_MESSAGE
import com.ronalad.mavaroo.utils.NetworkState
import com.ronalad.mavaroo.utils.UiState
import javax.inject.Inject

class GetTitleDetailsUseCase @Inject constructor(
    private val repo: IMBDbRepo
) {

    suspend operator fun invoke(id: String): UiState<TitleDetails> {
        return try {
            when (val result = repo.getTitleDetails(id)) {
                is NetworkState.Success -> {
                    UiState.Success(data = result.data ?: TitleDetails())
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