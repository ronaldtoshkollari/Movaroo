package com.ronalad.mavaroo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.ronalad.mavaroo.popular_movies.presentation.popular_movies.composables.PopularMoviesScreen
import com.ronalad.mavaroo.popular_movies.presentation.popular_movies.viewmodel.PopularMoviesViewModel
import com.ronalad.mavaroo.title_details.presentation.composables.TitleDetailsScreen
import com.ronalad.mavaroo.title_details.presentation.viewmodel.TitleDetailsViewModel
import com.ronalad.mavaroo.ui.theme.MovarooTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: PopularMoviesViewModel by viewModels()
    private val newViewModel: TitleDetailsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MovarooTheme {
//                val popularMoviesState = viewModel.popularMoviesState.collectAsState()
//                PopularMoviesScreen(
//                    popularMovies = popularMoviesState.value.popularMovies,
//                    isLoading = popularMoviesState.value.isLoading,
//                    errorMessage = popularMoviesState.value.errorMessage
//                )

                val state by newViewModel.titleDetailsState.collectAsState()
                newViewModel.getTitleDetails("tt0110414")
                TitleDetailsScreen(
                    titleDetails = state.titleDetails,
                    isLoading = state.isLoading,
                    errorMessage = state.errorMessage,
                    onActorClick = {},
                    onSimilarTitleClick = {}
                )
            }
        }
    }
}
