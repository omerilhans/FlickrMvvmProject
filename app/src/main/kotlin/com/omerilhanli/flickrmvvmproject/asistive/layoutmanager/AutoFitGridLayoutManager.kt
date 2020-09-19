package com.omerilhanli.flickrmvvmproject.asistive.layoutmanager

import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import kotlin.math.max

class AutoFitGridLayoutManager(private val mContext: Context) :
    GridLayoutManager(mContext, COUNT) {
    private var columnWidth = 0
    private var columnWidthChanged = true
    private val screenWidth: Int
        get() = Resources.getSystem().displayMetrics.widthPixels

    private fun setColumnWidth(newColumnWidth: Int) {
        if (newColumnWidth > 0 && newColumnWidth != columnWidth) {
            columnWidth = newColumnWidth
            columnWidthChanged = true
        }
    }

    override fun onLayoutChildren(
        recycler: Recycler,
        state: RecyclerView.State
    ) {
        if (columnWidthChanged && columnWidth > 0) {
            val totalSpace = width - paddingRight - paddingLeft
            val orientation = mContext.resources.configuration.orientation
            var spanCount = max(
                COUNT,
                totalSpace / columnWidth
            )
            if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
                spanCount++
            }
            setSpanCount(spanCount)
            columnWidthChanged = false
        }
        super.onLayoutChildren(recycler, state)
    }

    companion object {
        private const val COUNT = 2
    }

    init {
        setColumnWidth(screenWidth / COUNT)
    }
}