package com.ronalad.mavaroo.title_details.domain.model

import com.ronalad.mavaroo.title_details.data.dto.TitleDetailsDto

data class TitleDetails(
    val id: String = "",
    val actorList: List<Actor> = emptyList(),
    val directors: List<Director> = emptyList(),
    val errorMessage: String = "",
    val fullTitle: String = "",
    val genres: String = "",
    val image: String = "",
    val imDbRating: String = "",
    val originalTitle: String = "",
    val plot: String = "",
    val releaseDate: String = "",
    val runTime: String = "",
    val similarTitles: List<SimilarTitle> = emptyList()
) {
    constructor(titleDetailsDto: TitleDetailsDto) : this(
        id = titleDetailsDto.id,
        actorList = titleDetailsDto.actorDtoList.map { Actor(it) },
        directors = titleDetailsDto.directorDtoList.map { Director(it) },
        errorMessage = titleDetailsDto.errorMessage,
        fullTitle = titleDetailsDto.fullTitle,
        genres = titleDetailsDto.genres,
        image = titleDetailsDto.image,
        imDbRating = titleDetailsDto.imDbRating,
        originalTitle = titleDetailsDto.originalTitle,
        plot = titleDetailsDto.plot,
        releaseDate = titleDetailsDto.releaseDate,
        runTime = titleDetailsDto.runtimeStr,
        similarTitles = titleDetailsDto.similarTitlesDtos.map { SimilarTitle(it) }
    )
}
