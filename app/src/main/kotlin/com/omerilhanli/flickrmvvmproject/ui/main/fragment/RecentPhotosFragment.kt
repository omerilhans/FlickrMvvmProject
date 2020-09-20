package com.omerilhanli.flickrmvvmproject.ui.main.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.omerilhanli.flickrmvvmproject.R
import com.omerilhanli.flickrmvvmproject.asistive.layoutmanager.AutoFitGridLayoutManager
import com.omerilhanli.flickrmvvmproject.asistive.util.PhotoPathUtil
import com.omerilhanli.flickrmvvmproject.databinding.FragmentRecentPhotosBinding
import com.omerilhanli.flickrmvvmproject.ui.adapter.RecyclerPhotosAdapter
import com.omerilhanli.flickrmvvmproject.ui.base.BaseAdapter
import com.omerilhanli.flickrmvvmproject.ui.base.BaseFragment
import com.omerilhanli.flickrmvvmproject.ui.main.MainActivity
import com.omerilhanli.flickrmvvmproject.ui.main.MainViewModel
import com.omerilhanli.module_api.entity.Photo
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecentPhotosFragment : BaseFragment<FragmentRecentPhotosBinding>(R.layout.fragment_recent_photos),
    SwipeRefreshLayout.OnRefreshListener,
    BaseAdapter.ItemClickListener<Photo>,
    RecyclerPhotosAdapter.OnScrollToBottom {

    private val viewModel by activityViewModels<MainViewModel>()

    private lateinit var adapter: RecyclerPhotosAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // // // //
        set()
        observe()
    }

    private fun set() {

        viewModel.navigator = activity as MainActivity

        binding?.let {
            with(it) {
                lifecycleOwner = this@RecentPhotosFragment
                handler = this@RecentPhotosFragment.viewModel

                adapter = RecyclerPhotosAdapter.instance
                adapter.onScrollToBottom = this@RecentPhotosFragment
                adapter.itemClickListener = this@RecentPhotosFragment

                recyclerRecentlyPhotos.adapter = adapter
                recyclerRecentlyPhotos.layoutManager = AutoFitGridLayoutManager(requireContext())
                swipeRefreshLayoutRecentPhotos.setOnRefreshListener(this@RecentPhotosFragment)
            }
        }
    }

    private fun observe() {
        viewModel
            .liveDataRecentPhotos
            .observe(viewLifecycleOwner,
                Observer {
                    adapter.add(it?.photos?.photoArrayList)
                })
    }

    override fun onClickItem(data: Photo?) {
        data?.let {
            viewModel.photoInfoMap.id = it.id
            viewModel.photoInfoMap.title = it.title
            viewModel.photoInfoMap.desc = it.description
            viewModel.photoInfoMap.photoPath = PhotoPathUtil.getPhotoPathBig(it)
        }

        viewModel.navigator?.navigateToDetail(this)
    }

    override fun onRefresh() {
        adapter.clear()
        viewModel.navigator?.getRecentPhotos(isPageIncrease = false)
    }

    override fun onScrollToBottom(visible: Boolean) {
        if (visible) {
            viewModel.navigator?.getRecentPhotos(isPageIncrease = true)
        }
    }
}