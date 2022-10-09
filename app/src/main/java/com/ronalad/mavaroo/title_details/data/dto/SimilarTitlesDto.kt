package com.ronalad.mavaroo.title_details.data.dto

import com.google.gson.annotations.SerializedName

data class SimilarTitlesDto(
    @SerializedName("id")
    private val _id: String? = "",
    @SerializedName("imDbRating")
    private val _imDbRating: String? = "",
    @SerializedName("image")
    private val _image: String? = "",
    @SerializedName("title")
    private val _title: String? = ""
) {
    val id: String
        get() = _id ?: ""

    val imDbRating: String
        get() = _imDbRating ?: ""

    val image: String
        get() = _image ?: ""

    val title: String
        get() = _title ?: ""
}