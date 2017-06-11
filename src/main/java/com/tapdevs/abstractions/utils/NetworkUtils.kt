package com.tapdevs.abstractions.utils

import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import com.tapdevs.abstractions.eventHandlers.NetworkStatus
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

    fun getReachability(context: Context): NetworkStatus {
        val connectivityManager = context.applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        AbstractionOrUtilsConstants.networkStatus = NetworkStatus.networkStatusNotReachable
        connectivityManager?.let {
            val networkInfo = connectivityManager.activeNetworkInfo
            if (networkInfo != null) {
                if (networkInfo.isConnected && networkInfo.isAvailable) {
                    if (networkInfo.type == ConnectivityManager.TYPE_WIFI) {
                        AbstractionOrUtilsConstants.networkStatus =  NetworkStatus.networkStatusReachableViaWiFi
                    } else if (networkInfo.type == ConnectivityManager.TYPE_WIMAX || networkInfo.type == ConnectivityManager.TYPE_MOBILE) {
                        AbstractionOrUtilsConstants.networkStatus =  NetworkStatus.networkStatusReachableViaWWAN
                    } else {
                        AbstractionOrUtilsConstants.networkStatus =  NetworkStatus.networkStatusReachableViaWWAN
                    }
                }
            }
        }
        return AbstractionOrUtilsConstants.networkStatus ;
    }


}
