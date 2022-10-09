package com.ronalad.mavaroo.title_details.data.dto

import com.google.gson.annotations.SerializedName

data class BoxOfficeDto(
    @SerializedName("budget")
    private val _budget: String? = "",
    @SerializedName("cumulativeWorldwideGross")
    private val _cumulativeWorldwideGross: String? = "",
    @SerializedName("grossUSA")
    private val _grossUSA: String? = "",
    @SerializedName("openingWeekendUSA")
    private val _openingWeekendUSA: String? = ""
) {
    val budget: String
        get() = _budget ?: ""

    val cumulativeWorldwideGross: String
        get() = _cumulativeWorldwideGross ?: ""

    val grossUSA: String
        get() = _grossUSA ?: ""

    val openingWeekendUSA: String
        get() = _openingWeekendUSA ?: ""
}