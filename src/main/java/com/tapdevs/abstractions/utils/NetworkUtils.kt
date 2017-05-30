package com.tapdevs.abstractions.utils

import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import com.tapdevs.abstractions.utils.SnackBarUtils.showSnackBarOnNoInternet

/**
 * Created by  Jan Shair on 08/02/2017.
 */

object NetworkUtils {

    fun checkInternet(context: Activity): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        if (!(activeNetworkInfo != null && activeNetworkInfo.isConnected)) {
            showSnackBarOnNoInternet(context)
            return false
        }
        return true
    }


}
