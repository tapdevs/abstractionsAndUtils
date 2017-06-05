package com.tapdevs.abstractions.views

import android.app.Activity
import android.app.FragmentManager
import android.content.IntentFilter
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.tapdevs.abstractions.eventHandlers.*
import com.tapdevs.abstractions.utils.NetworkReachabilityReceiver
import com.tapdevs.abstractions.utils.SnackBarUtils
import org.json.JSONObject


abstract class BaseActivity : AppCompatActivity() {

    var networkReachabilityReceiver: NetworkReachabilityReceiver? = null
    private var networkReachabilityListner: IEventHandler? = null
    private var event: IEvent? = null
    private var context: Activity? = this


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependencies()
        registerNetworkReachabilityListners()
    }


    /**
     * Create a new Dagger ObjectGraph to add new dependencies using a plus operation and inject the
     * declared one in the activity. This new graph will be destroyed once the activity lifecycle
     * finish.

     * This is the key of how to use Activity scope dependency injection.
     */
    abstract fun injectDependencies()

    /**
     * Options items selected
     * @param item
     * *
     * @return
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                val fm = fragmentManager
                if (fm.backStackEntryCount > 0) {
                    fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
                } else {
                    finish()
                }
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    private fun registerNetworkReachabilityListners() {
        event = Event()
        val filter = IntentFilter()
        filter.addAction("android.net.conn.CONNECTIVITY_CHANGE")
        filter.addAction("android.net.wifi.WIFI_STATE_CHANGED")
        networkReachabilityReceiver = NetworkReachabilityReceiver()
        networkReachabilityReceiver!!.setEvent(event as Event)
        registerReceiver(networkReachabilityReceiver, filter)

        this.networkReachabilityListner = (event as Event).listen(this, NetworkReachabilityReceiver.networkChangeRecieverOnRecieve, object : EventListener() {
            override fun receiveEvent(eventName: String, data: JSONObject) {
                val networkStatus = data.opt(NetworkReachabilityReceiver.networkStatusKey) as String
                val networkNotReachableStatus = NetworkStatus.networkStatusNotReachable.toString()

                if (networkStatus == networkNotReachableStatus) {
                    SnackBarUtils.showSnackBarOnNoInternet(context!!)
                }
            }
        })
    }

    private fun unregisterNetworkReachabilityListners() {
        if (networkReachabilityListner != null) {
            networkReachabilityListner!!.close()
            networkReachabilityListner = null
        }
    }


}
