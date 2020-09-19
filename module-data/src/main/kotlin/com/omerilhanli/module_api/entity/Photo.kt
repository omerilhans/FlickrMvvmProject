package com.omerilhanli.module_api.entity

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class Photo : Parcelable {
    @SerializedName("id")
    var id: String? = null

    @SerializedName("owner")
    var owner: String? = null

    @SerializedName("secret")
    var secret: String? = null

    @SerializedName("farm")
    var farm: String? = null

    @SerializedName("server")
    var server: String? = null

    @SerializedName("title")
    var title: String? = null

    @SerializedName("description")
    var description: String? = null

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(id)
        dest.writeString(owner)
        dest.writeString(secret)
        dest.writeString(farm)
        dest.writeString(server)
        dest.writeString(title)
        dest.writeString(description)
    }

    constructor() {}
    protected constructor(`in`: Parcel) {
        id = `in`.readString()
        owner = `in`.readString()
        secret = `in`.readString()
        farm = `in`.readString()
        server = `in`.readString()
        title = `in`.readString()
        description = `in`.readString()
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Photo> =
            object : Parcelable.Creator<Photo> {
                override fun createFromParcel(source: Parcel): Photo? {
                    return Photo(source)
                }

                override fun newArray(size: Int): Array<Photo?> {
                    return arrayOfNulls(size)
                }
            }
    }
}