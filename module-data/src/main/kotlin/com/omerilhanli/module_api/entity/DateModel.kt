package com.omerilhanli.module_api.entity

import com.google.gson.annotations.SerializedName

data class DateModel(
    @SerializedName("posted")
    val postDate: String? = null,
    @SerializedName("taken")
    val takenDate: String? = null,
    @SerializedName("lastupdate")
    val lastUpdate: String? = null
)
