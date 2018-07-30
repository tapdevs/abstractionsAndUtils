package com.tapdevs.abstractions.utils

import android.content.Context
import android.content.Intent
import android.support.v4.app.ShareCompat
import android.support.v7.widget.DialogTitle
import com.tapdevs.abstractions.views.BaseActivity

/**
 * Created by  Jan Shair on 16/02/2017.
 */

object IntentUtils {

    fun connectToWifi(context: Context) {
        context.startActivity(Intent(android.provider.Settings.ACTION_WIFI_SETTINGS))
    }

    fun shareLink(activity : BaseActivity,title: String, text : String){
        ShareCompat.IntentBuilder.from(activity)
                .setType("text/plain")
                .setChooserTitle(title)
                .setText(text)
                .startChooser();
    }
}
