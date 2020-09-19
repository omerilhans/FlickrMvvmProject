package com.omerilhanli.flickrmvvmproject.ui.base

import android.os.Bundle
import androidx.annotation.*
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.omerilhanli.flickrmvvmproject.R
import com.omerilhanli.flickrmvvmproject.asistive.alert.AppAlert
import retrofit2.HttpException
import java.net.UnknownHostException

abstract class BaseActivity<Binding : ViewDataBinding>(@LayoutRes var layoutId: Int) :
    AppCompatActivity(), BaseNavigator {

    @Nullable
    var binding: Binding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil
            .setContentView<Binding>(this, layoutId)
            .apply {
                binding = this
            }
    }

    override fun handleError(error: Throwable) {
        showErrorMessage(getMessageFromError(error))
    }

    private fun showErrorMessage(message: String) {
        AppAlert.showAlert(
            this,
            getString(R.string.popup_btn_title),
            message,
            getString(R.string.popup_btn_text)
        )
    }

    private fun getMessageFromError(error: Throwable) = when (error) {
        is HttpException -> {
            when {
                error.response()?.code() == 404 -> {
                    resources.getString(R.string.err_not_found_404)
                }
                error.response()?.code() == 503 -> {
                    resources.getString(R.string.err_service_unavailable_503)
                }
                else -> {
                    resources.getString(R.string.err_generic_message)
                }
            }
        }
        is UnknownHostException -> {
            resources.getString(R.string.err_network_unavailable)
        }
        else -> {
            resources.getString(R.string.err_generic_message)
        }
    }


}