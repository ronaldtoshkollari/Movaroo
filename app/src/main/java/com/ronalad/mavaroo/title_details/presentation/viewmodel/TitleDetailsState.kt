package com.ronalad.mavaroo.title_details.presentation.viewmodel

import com.ronalad.mavaroo.title_details.domain.model.TitleDetails

data class TitleDetailsState(
    val titleDetails: TitleDetails = TitleDetails(),
    val isLoading: Boolean = true,
    val errorMessage: String = ""
)
