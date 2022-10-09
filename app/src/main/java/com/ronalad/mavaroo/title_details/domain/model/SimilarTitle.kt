package com.ronalad.mavaroo.title_details.domain.model

import com.ronalad.mavaroo.title_details.data.dto.SimilarTitlesDto

data class SimilarTitle(
    val id: String = "",
    val imDbRating: String = "",
    val image: String = "",
    val title: String = ""
) {
    constructor(similarTitlesDto: SimilarTitlesDto) : this(
        id = similarTitlesDto.id,
        imDbRating = similarTitlesDto.imDbRating,
        image = similarTitlesDto.image,
        title = similarTitlesDto.title
    )
}
