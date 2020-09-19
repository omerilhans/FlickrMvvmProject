package com.omerilhanli.flickrmvvmproject.extensive

import android.content.Context
import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContextCompat
import com.omerilhanli.flickrmvvmproject.R

fun Context.openLinkOnBrowser(url: String?) {
    url?.let {
        val builder = CustomTabsIntent.Builder()
        builder.setToolbarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark))
        val customTabsIntent = builder.build()
        customTabsIntent.launchUrl(this, Uri.parse(url))
    }
}
