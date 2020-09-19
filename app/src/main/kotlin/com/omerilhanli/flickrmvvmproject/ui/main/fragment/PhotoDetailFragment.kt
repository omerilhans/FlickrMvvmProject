package com.omerilhanli.flickrmvvmproject.ui.main.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.omerilhanli.flickrmvvmproject.R
import com.omerilhanli.flickrmvvmproject.databinding.FragmentPhotoDetailBinding
import com.omerilhanli.flickrmvvmproject.extensive.bindPhotoPath
import com.omerilhanli.flickrmvvmproject.ui.base.BaseFragment
import com.omerilhanli.flickrmvvmproject.ui.main.MainActivity
import com.omerilhanli.flickrmvvmproject.ui.main.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PhotoDetailFragment : BaseFragment<FragmentPhotoDetailBinding>(R.layout.fragment_photo_detail),
    View.OnClickListener {

    private val viewModel by activityViewModels<MainViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // // // //
        set()
        fetch()
        observe()
    }

    private fun set() {

        viewModel.navigator = activity as MainActivity

        binding?.let {
            with(it) {
                lifecycleOwner = viewLifecycleOwner
                handler = this@PhotoDetailFragment.viewModel
                viewModel = this@PhotoDetailFragment.viewModel

                linearBack.setOnClickListener(this@PhotoDetailFragment)
            }
        }
    }

    private fun fetch() {
        viewModel.navigator?.getPhotoDetail()
    }

    private fun observe() {
        viewModel
            .liveDataPhotoInfo
            .observe(viewLifecycleOwner,
                Observer { response ->

                    with(response) {
                        viewModel
                            .photoInfoMap
                            .apply {
                                username = photo?.owner?.username
                            }
                    }
                })
    }

    override fun onClick(v: View?) {
        viewModel.navigator?.navigateToBack(this)
    }
}