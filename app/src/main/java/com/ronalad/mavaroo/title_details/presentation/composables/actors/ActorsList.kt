package com.ronalad.mavaroo.title_details.presentation.composables.actors

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ronalad.mavaroo.title_details.domain.model.Actor

@Composable
fun ActorsList(
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    verticalArrangement: Arrangement.Vertical = Arrangement.Top,
    actors: List<Actor>,
    onClick: (id: String) -> Unit
) {

    LazyColumn(
        modifier = modifier,
        contentPadding = contentPadding,
        verticalArrangement = verticalArrangement
    ) {

        items(actors,
            key = { actor ->
                actor.id
            }
        ) { actor ->
            ActorComposable(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onClick(actor.id) },
                image = actor.image,
                name = actor.name,
                character = actor.character
            )
        }

    }

}