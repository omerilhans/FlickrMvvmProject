package com.omerilhanli.flickrmvvmproject.ui.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.omerilhanli.flickrmvvmproject.R
import com.omerilhanli.flickrmvvmproject.databinding.ActivityMainBinding
import com.omerilhanli.flickrmvvmproject.extensive.*
import com.omerilhanli.flickrmvvmproject.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main), MainNavigator {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // // // //
        set()
    }

    private fun set() {
        viewModel.navigator = this
        binding?.let {
            with(it) {
                lifecycleOwner = this@MainActivity
                handler = viewModel
            }
        }
    }

    override fun getRecentPhotos(isPageIncrease: Boolean) {
        if (isPageIncrease) {
            viewModel.increasePageNumber()
        } else {
            viewModel.resetPageNumber()
        }

        viewModel.fetchRecentPhotos()
    }

    override fun getPhotoDetail() {
        viewModel.fetchPhotoDetail()
    }

    override fun navigateToDetail(fragment: Fragment) {
        NavHostFragment.findNavController(fragment).navigate(R.id.action_Recent_to_Detail)
    }

    override fun navigateToBack(fragment: Fragment) {
        NavHostFragment.findNavController(fragment).navigate(R.id.action_Detail_to_Recent)
    }

    // ))---------------------------------------------------(( \\
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.app_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_link -> openLinkOnBrowser(CHALLENGE_GITHUB_LINK)
        }
        return super.onOptionsItemSelected(item)
    }
}
