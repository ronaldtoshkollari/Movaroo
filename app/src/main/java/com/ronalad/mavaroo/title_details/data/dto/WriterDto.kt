package com.ronalad.mavaroo.title_details.data.dto

import com.google.gson.annotations.SerializedName

data class WriterDto(
    @SerializedName("id")
    private val _id: String? = "",
    @SerializedName("name")
    private val _name: String? = ""
) {
    val id: String
        get() = _id ?: ""

    val name: String
        get() = _name ?: ""
}