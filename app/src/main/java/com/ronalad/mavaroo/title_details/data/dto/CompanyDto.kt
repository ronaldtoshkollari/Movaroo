package com.ronalad.mavaroo.title_details.data.dto

import com.google.gson.annotations.SerializedName

data class CompanyDto(
    @SerializedName("id")
    private val _id: String? = "",
    @SerializedName("_name")
    private val _name: String? = ""
) {
    val id: String
        get() = _id ?: ""

    val name: String
        get() = _name ?: ""
}