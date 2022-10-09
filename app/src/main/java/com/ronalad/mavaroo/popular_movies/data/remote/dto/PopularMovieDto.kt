package com.ronalad.mavaroo.popular_movies.data.remote.dto

import com.google.gson.annotations.SerializedName

data class PopularMovieDto(
    @SerializedName("id")
    private val _id: String? = "",
    @SerializedName("rank")
    private val _rank: String? = "",
    @SerializedName("rankUpDown")
    private val _rankUpDown: String? = "",
    @SerializedName("title")
    private val _title: String? = "",
    @SerializedName("fullTitle")
    private val _fullTitle: String? = "",
    @SerializedName("year")
    private val _year: String? = "",
    @SerializedName("image")
    private val _image: String? = "",
    @SerializedName("crew")
    private val _crew: String? = "",
    @SerializedName("imDbRating")
    private val _imDbRating: String? = "",
    @SerializedName("imDbRatingCount")
    private val _imDbRatingCount: String? = ""
) {

    val id: String
        get() = _id ?: ""

    val rank: Int
        get() = _rank?.toIntOrNull() ?: -1

    val rankUpDown: String
        get() = _rankUpDown ?: ""

    val title: String
        get() = _title ?: ""

    val fullTitle: String
        get() = _fullTitle ?: ""

    val year: Int
        get() = _year?.toIntOrNull() ?: -1

    val image: String
        get() = _image ?: ""

    val crew: String
        get() = _crew ?: ""

    val imDbRating: Double
        get() = _imDbRating?.toDoubleOrNull() ?: 0.0

    val imDbRatingCount: Int
        get() = _imDbRatingCount?.toIntOrNull() ?: -1

}
