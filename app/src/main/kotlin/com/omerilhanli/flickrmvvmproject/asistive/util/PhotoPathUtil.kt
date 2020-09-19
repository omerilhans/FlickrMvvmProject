package com.omerilhanli.flickrmvvmproject.asistive.util

import com.omerilhanli.module_api.entity.Photo

object PhotoPathUtil {

    @JvmStatic
    fun getPhotoPathSmall(photo: Photo?): String? {
        photo
            ?.let {
                with(it) {
                    return String.format(
                        "https://farm%s.staticflickr.com/%s/%s_%s_%c.jpg",
                        farm,
                        server,
                        id,
                        secret,
                        'm'
                    )
                }
            }

        return null
    }

    @JvmStatic
    fun getPhotoPathBig(photo: Photo?): String? {
        photo
            ?.let {
                with(it) {
                    return String.format(
                        "https://farm%s.staticflickr.com/%s/%s_%s_%c.jpg",
                        farm,
                        server,
                        id,
                        secret,
                        'b'
                    )
                }
            }

        return null
    }
}