package com.omerilhanli.flickrmvvmproject.ui.adapter

import android.view.ViewGroup
import com.omerilhanli.flickrmvvmproject.R
import com.omerilhanli.flickrmvvmproject.ui.adapter.viewholder.PhotosViewHolder
import com.omerilhanli.flickrmvvmproject.ui.base.BaseAdapter
import com.omerilhanli.module_api.entity.Photo

class RecyclerPhotosAdapter(list: ArrayList<Photo>?) : BaseAdapter<PhotosViewHolder, Photo>(list, R.layout.item_photo) {

    var itemClickListener: ItemClickListener<Photo>? = null

    var onScrollToBottom: OnScrollToBottom? = null

    override fun createdView(parent: ViewGroup, viewType: Int): PhotosViewHolder {
        PhotosViewHolder(binding, itemClickListener)
            .also {
                return it
            }
    }

    override fun bindView(holder: PhotosViewHolder, position: Int) {
        mDataList?.let {
            holder.bind(it[position])
        }

        if (position == itemCount - 1) {
            onScrollToBottom?.onScrollToBottom(true)
        } else {
            onScrollToBottom?.onScrollToBottom(false)
        }
    }

    interface OnScrollToBottom {
        fun onScrollToBottom(visible: Boolean)
    }

    companion object {
        val instance = RecyclerPhotosAdapter(ArrayList())
    }
}

