package com.ronalad.mavaroo.title_details.data.dto

import com.google.gson.annotations.SerializedName

data class ActorDto(
    @SerializedName("asCharacter")
    private val _asCharacter: String? = "",
    @SerializedName("id")
    private val _id: String? = "",
    @SerializedName("image")
    private val _image: String? = "",
    @SerializedName("name")
    private val _name: String? = ""
) {
    val asCharacter: String
        get() = _asCharacter ?: ""

    val id: String
        get() = _id ?: ""

    val image: String
        get() = _image ?: ""

    val name: String
        get() = _name ?: ""
}