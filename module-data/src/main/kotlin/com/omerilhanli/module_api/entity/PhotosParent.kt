package com.omerilhanli.module_api.entity

import com.google.gson.annotations.SerializedName

class PhotosParent {
    @SerializedName("photos")
    var photos: Photos? = null
        internal set

    @SerializedName("stat")
    var stat: String? = null
        internal set
}
