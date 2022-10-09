package com.ronalad.mavaroo.popular_movies.presentation.popular_movies.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.ronalad.mavaroo.popular_movies.domain.model.PopularMovie

@Composable
fun MoviesList(
    movies: List<PopularMovie>
) {

    val state = rememberLazyListState()

    LazyColumn(
        state = state,
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(
            key = { popularMovie -> popularMovie.id },
            items = movies
        ) { popularMovie ->
            MovieItem(
                title = popularMovie.title,
                image = popularMovie.image,
                type = "Movie",
                rating = popularMovie.imDbRating
            )
        }
    }
}