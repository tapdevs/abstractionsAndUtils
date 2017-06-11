package com.tapdevs.abstractions.utils

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import com.tapdevs.abstractions.eventHandlers.IEvent
import com.tapdevs.abstractions.eventHandlers.NetworkStatus
import com.tapdevs.abstractions.utils.NetworkUtils.getReachability
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