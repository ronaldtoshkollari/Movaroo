package com.ronalad.mavaroo.presentation.popular_movies.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ronalad.mavaroo.domain.use_cases.GetPopularMoviesUseCase
import com.ronalad.mavaroo.utils.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PopularMoviesViewModel @Inject constructor(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase
) : ViewModel() {

    private val _popularMoviesState: MutableStateFlow<PopularMoviesState> = MutableStateFlow(PopularMoviesState())
    val popularMoviesState = _popularMoviesState.asStateFlow()

    init {
        getPopularMovies()
    }

    private fun getPopularMovies() {
        viewModelScope.launch {
            when(val response = getPopularMoviesUseCase()) {
                is UiState.Success -> {
                    val popularMovies = response.data ?: emptyList()
                    _popularMoviesState.value = _popularMoviesState.value.copy(popularMovies = popularMovies, isLoading = false, errorMessage = "")
                }

                is UiState.Error -> {
                    _popularMoviesState.value = PopularMoviesState(isLoading = false, errorMessage = response.message ?: "")
                }

                else -> {
                    _popularMoviesState.value = PopularMoviesState(isLoading = true)
                }
            }
        }
    }

}