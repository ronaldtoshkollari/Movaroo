package com.ronalad.mavaroo.title_details.domain.model

import com.ronalad.mavaroo.title_details.data.dto.DirectorDto

data class Director(
    val id: String,
    val name: String
) {
    constructor(directorDto: DirectorDto) : this(
        id = directorDto.id,
        name = directorDto.name
    )
}
