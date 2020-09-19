package com.omerilhanli.module_api.entity

import com.google.gson.annotations.SerializedName

data class Owner(
    @SerializedName("nsid")
    val nsId: String? = null,
    @SerializedName("username")
    val username: String? = null,
    @SerializedName("realname")
    val realName: String? = null,
    @SerializedName("location")
    val location: String? = null
)
