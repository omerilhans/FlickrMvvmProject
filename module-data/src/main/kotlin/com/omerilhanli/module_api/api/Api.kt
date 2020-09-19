package com.omerilhanli.module_api.api

import com.omerilhanli.module_api.BuildConfig
import com.omerilhanli.module_api.common.*
import com.omerilhanli.module_api.entity.PhotoInfoParent
import com.omerilhanli.module_api.entity.PhotosParent

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET(END_GET_RECENT)
    fun getRecent(
        @Query(CONST_API_KEY) apiKey: String = BuildConfig.KEY_API_VALUE,
        @Query(CONST_FORMAT) format: String = CONST_FORMAT_VALUE,
        @Query(CONST_NO_JSON_CALLBACK) noJsonCallback: Int = CONST_NO_JSON_CALLBACK_VALUE,
        @Query(CONST_PER_PAGE) perPage: Int = CONST_PER_PAGE_VALUE,
        @Query(CONST_PAGE) page: Int
    ): Observable<PhotosParent>

    @GET(END_GET_INFO)
    fun getInfo(
        @Query(CONST_API_KEY) apiKey: String = BuildConfig.KEY_API_VALUE,
        @Query(CONST_FORMAT) format: String = CONST_FORMAT_VALUE,
        @Query(CONST_NO_JSON_CALLBACK) noJsonCallback: Int = CONST_NO_JSON_CALLBACK_VALUE,
        @Query(CONST_PHOTO_ID) photoId: String
    ): Observable<PhotoInfoParent>
}