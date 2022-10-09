package com.ronalad.mavaroo.title_details.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ronalad.mavaroo.title_details.domain.model.TitleDetails
import com.ronalad.mavaroo.title_details.domain.use_cases.GetTitleDetailsUseCase
import com.ronalad.mavaroo.utils.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TitleDetailsViewModel @Inject constructor(
    private val getTitleDetailsUseCase: GetTitleDetailsUseCase
) : ViewModel() {

    private val _titleDetailsState: MutableStateFlow<TitleDetailsState> = MutableStateFlow(TitleDetailsState())
    val titleDetailsState = _titleDetailsState.asStateFlow()

    fun getTitleDetails(id: String) {
        viewModelScope.launch {
            when (val response = getTitleDetailsUseCase(id)) {
                is UiState.Success -> {
                    val titleDetails = response.data
                    _titleDetailsState.value = _titleDetailsState.value.copy(
                        titleDetails = titleDetails ?: TitleDetails(), isLoading = false
                    )

                }

                is UiState.Error -> {
                    _titleDetailsState.value =
                        TitleDetailsState(isLoading = false, errorMessage = response.message ?: "")
                }

                else -> {
                    _titleDetailsState.value = TitleDetailsState(isLoading = true)
                }
            }
        }
    }


}