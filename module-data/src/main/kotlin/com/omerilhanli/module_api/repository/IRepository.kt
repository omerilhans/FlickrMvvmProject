package com.omerilhanli.module_api.repository

import com.omerilhanli.module_api.entity.PhotoInfoParent
import com.omerilhanli.module_api.entity.PhotosParent
import io.reactivex.Observable

interface IRepository {
    fun getPublishedRecentPhotos(page: Int) : Observable<PhotosParent>
    fun getPublishedPhotoInfo(photoId: String) : Observable<PhotoInfoParent>
}