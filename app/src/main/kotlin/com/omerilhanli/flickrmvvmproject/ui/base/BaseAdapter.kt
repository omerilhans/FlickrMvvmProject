package com.omerilhanli.flickrmvvmproject.ui.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<VH : RecyclerView.ViewHolder, Data>(
    var mDataList: ArrayList<Data>? = null,
    @LayoutRes var itemLayoutId: Int
) : RecyclerView.Adapter<VH>() {

    lateinit var binding: ViewDataBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        DataBindingUtil
            .inflate<ViewDataBinding>(LayoutInflater.from(parent.context), itemLayoutId, parent, false)
            .apply {
                binding = this
            }.also {
                return createdView(parent, viewType)
            }
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        bindView(holder, position)
    }

    override fun getItemCount() = mDataList?.size ?: 0

    fun clear() {
        mDataList?.clear()
        notifyDataSetChanged()
    }

    fun add(newList: ArrayList<Data>?) {
        newList?.let {
            mDataList?.addAll(it)
            notifyDataSetChanged()
        }
    }

    abstract fun createdView(parent: ViewGroup, viewType: Int): VH
    abstract fun bindView(holder: VH, position: Int)

    interface ItemClickListener<Type> {
        fun onClickItem(data: Type? = null)
    }
}