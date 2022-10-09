package com.ronalad.mavaroo.title_details.domain.model

import com.ronalad.mavaroo.title_details.data.dto.ActorDto

data class Actor(
    val id: String = "",
    val image: String = "",
    val name: String = "",
    val character: String = ""
) {
    constructor(actorDto: ActorDto): this(
        id = actorDto.id,
        image = actorDto.image,
        name = actorDto.name,
        character = actorDto.asCharacter
    )
}
