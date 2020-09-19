package com.omerilhanli.module_api.entity

import com.google.gson.annotations.SerializedName

data class PhotoInfoParent(
    @SerializedName("photo")
    val photo: PhotoInfo? = null,
    @SerializedName("stat")
    val stat: String? = null
)
