package com.ronalad.mavaroo.title_details.data.dto

import com.google.gson.annotations.SerializedName

data class GenreDto(
    @SerializedName("key")
    private val _key: String? = "",
    @SerializedName("value")
    private val _value: String? = ""
) {
    val key: String
        get() = _key ?: ""

    val value: String
        get() = _value ?: ""
}