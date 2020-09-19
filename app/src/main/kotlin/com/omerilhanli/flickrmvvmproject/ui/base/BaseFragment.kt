package com.omerilhanli.flickrmvvmproject.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.annotation.Nullable
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<Binding : ViewDataBinding>(
    @LayoutRes var layoutId: Int
) : Fragment() {

    @Nullable
    var binding: Binding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        DataBindingUtil
            .inflate<Binding>(inflater, layoutId, container, false)
            .apply {
                binding = this
            }.also {
                return it.root
            }
    }
}