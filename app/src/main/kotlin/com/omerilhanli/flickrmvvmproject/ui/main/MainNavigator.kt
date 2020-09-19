package com.omerilhanli.flickrmvvmproject.ui.main

import androidx.fragment.app.Fragment
import com.omerilhanli.flickrmvvmproject.ui.base.BaseNavigator

interface MainNavigator : BaseNavigator {

    fun getRecentPhotos(isPageIncrease: Boolean)

    fun getPhotoDetail()


    fun navigateToDetail(fragment: Fragment)

    fun navigateToBack(fragment: Fragment)
}