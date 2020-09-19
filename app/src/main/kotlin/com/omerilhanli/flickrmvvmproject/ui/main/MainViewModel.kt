package com.omerilhanli.flickrmvvmproject.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import com.omerilhanli.flickrmvvmproject.asistive.scheduler.SchedulerImpl
import com.omerilhanli.flickrmvvmproject.ui.base.BaseViewModel
import com.omerilhanli.module_api.entity.PhotoInfoMap
import com.omerilhanli.module_api.entity.PhotoInfoParent
import com.omerilhanli.module_api.repository.IRepository
import com.omerilhanli.module_api.entity.PhotosParent
import javax.inject.Singleton

@Singleton
class MainViewModel @ViewModelInject constructor(
    private val repository: IRepository?,
    schedulerImpl: SchedulerImpl
) : BaseViewModel<MainNavigator>(schedulerImpl) {

    val liveDataRecentPhotos: MutableLiveData<PhotosParent> = MutableLiveData()

    val liveDataPhotoInfo: MutableLiveData<PhotoInfoParent> = MutableLiveData()

    val photoInfoMap = PhotoInfoMap()

    private var mPage: Int = 1

    fun increasePageNumber() {
        mPage.inc()
    }

    fun resetPageNumber() {
        mPage = 1
    }

    fun fetchRecentPhotos() {
        repository
            ?.getPublishedRecentPhotos(page = mPage)
            ?.completion {
                liveDataRecentPhotos.value = it
            }
    }

    fun fetchPhotoDetail() {
        repository
            ?.getPublishedPhotoInfo(photoId = photoInfoMap.id ?: "")
            ?.completion {
                liveDataPhotoInfo.value = it
            }
    }

}