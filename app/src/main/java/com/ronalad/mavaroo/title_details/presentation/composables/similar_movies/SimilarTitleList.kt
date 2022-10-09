package com.ronalad.mavaroo.title_details.presentation.composables.similar_movies

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ronalad.mavaroo.title_details.domain.model.SimilarTitle

@Composable
fun SimilarTitleList(
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Start,
    similarTitles: List<SimilarTitle>,
    onClick: (id: String) -> Unit
) {
    LazyRow(
        modifier = modifier,
        contentPadding = contentPadding,
        horizontalArrangement = horizontalArrangement
    ) {
        items(similarTitles,
            key = { similarTitle ->
            similarTitle.id
        }
        ) { similarTitle ->
            SimilarTitleComposable(
                modifier = Modifier.clickable { onClick(similarTitle.id) },
                title = similarTitle.title,
                image = similarTitle.image,
                imDbRating = similarTitle.imDbRating
            )
        }
    }
}