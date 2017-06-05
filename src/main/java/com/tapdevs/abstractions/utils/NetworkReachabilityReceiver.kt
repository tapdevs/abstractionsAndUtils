package com.tapdevs.abstractions.utils

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import com.tapdevs.abstractions.eventHandlers.IEvent
import com.tapdevs.abstractions.eventHandlers.NetworkStatus
import org.json.JSONException
import org.json.JSONObject

/**
 * Created by Jan S. on 15/05/2017.
 */


class NetworkReachabilityReceiver : BroadcastReceiver() {
    private var event: IEvent? = null

    fun setEvent(event: IEvent) {
        this.event = event
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

    override fun onReceive(context: Context, intent: Intent) {

        val reachability = getReachability(context)
        val data = JSONObject()
        try {
            data.putOpt(networkStatusKey, reachability.toString())
        } catch (exception: JSONException) {

        }

        if (event != null) {
            event!!.post(context, networkChangeRecieverOnRecieve, data)
        }
    }

    companion object {

        val networkChangeRecieverOnRecieve = "networkChangeRecieverOnRecieve"
        val networkStatusKey = "networkStatus"
    }
}