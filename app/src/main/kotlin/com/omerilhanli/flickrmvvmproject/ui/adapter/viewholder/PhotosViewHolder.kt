package com.omerilhanli.flickrmvvmproject.ui.adapter.viewholder

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.omerilhanli.flickrmvvmproject.BR
import com.omerilhanli.flickrmvvmproject.ui.base.BaseAdapter
import com.omerilhanli.module_api.entity.Photo

class PhotosViewHolder(
    private val binding: ViewDataBinding,
    private val itemClickListener: BaseAdapter.ItemClickListener<Photo>? = null
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(photo: Photo) {
        with(binding) {
            setVariable(BR.photo, photo)
            setVariable(BR.itemClickListener, itemClickListener)
            executePendingBindings()
        }
    }
}