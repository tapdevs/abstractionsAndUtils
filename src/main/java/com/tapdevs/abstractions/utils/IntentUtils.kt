package com.tapdevs.abstractions.utils

import android.content.Context
import android.content.Intent

/**
 * Created by  Jan Shair on 16/02/2017.
 */

object IntentUtils {

    fun connectToWifi(context: Context) {
        context.startActivity(Intent(android.provider.Settings.ACTION_WIFI_SETTINGS))
    }
}
