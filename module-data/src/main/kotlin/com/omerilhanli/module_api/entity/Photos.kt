package com.omerilhanli.module_api.entity

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import java.util.*

class Photos : Parcelable {
    @SerializedName("page")
    var page: String? = null
        private set

    @SerializedName("pages")
    var pages: String? = null
        private set

    @SerializedName("perpage")
    var perPage: String? = null
        private set

    @SerializedName("total")
    var total: String? = null
        private set

    @SerializedName("photo")
    var photoArrayList: ArrayList<Photo>? = null
        private set

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(page)
        dest.writeString(pages)
        dest.writeString(perPage)
        dest.writeString(total)
        dest.writeTypedList(photoArrayList)
    }

    constructor() {}
    protected constructor(`in`: Parcel) {
        page = `in`.readString()
        pages = `in`.readString()
        perPage = `in`.readString()
        total = `in`.readString()
        photoArrayList = `in`.createTypedArrayList(Photo.CREATOR)
    }

    companion object {
        val CREATOR: Parcelable.Creator<Photos> = object : Parcelable.Creator<Photos> {
            override fun createFromParcel(source: Parcel): Photos? {
                return Photos(source)
            }

            override fun newArray(size: Int): Array<Photos?> {
                return arrayOfNulls(size)
            }
        }
    }
}