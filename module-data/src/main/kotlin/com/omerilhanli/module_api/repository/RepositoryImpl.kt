package com.omerilhanli.module_api.repository

import com.omerilhanli.module_api.api.Api
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepositoryImpl @Inject constructor(var api: Api) : IRepository {

    override fun getPublishedRecentPhotos(page: Int) = api.getRecent(page = page)

    override fun getPublishedPhotoInfo(photoId: String) = api.getInfo(photoId = photoId)
}