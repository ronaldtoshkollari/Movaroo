package com.ronalad.mavaroo.title_details.presentation.composables.actors

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ronalad.mavaroo.title_details.domain.model.Actor

@Composable
fun ActorsList(
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    horizontalArrangement: Arrangement.Horizontal,
    actors: List<Actor>,
    onClick: (id: String) -> Unit
) {

    LazyRow(
        modifier = modifier,
        contentPadding = contentPadding,
        horizontalArrangement = horizontalArrangement
    ) {

        items(actors,
            key = { actor ->
                actor.id
            }
        ) { actor ->
            ActorComposable(
                modifier = Modifier
                    .width(100.dp)
                    .clickable { onClick(actor.id) },
                image = actor.image,
                name = actor.name,
                character = actor.character
            )
        }

    }

}