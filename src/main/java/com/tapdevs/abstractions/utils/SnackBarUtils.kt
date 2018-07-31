package com.tapdevs.abstractions.utils

import android.app.Activity
import android.graphics.Color
import android.os.Build
import android.support.design.widget.Snackbar
import android.view.View
import android.widget.TextView
import com.tapdevs.abstractions.R
import com.tapdevs.abstractions.views.BaseActivity


/**
 * Created by  Jan Shair on 16/02/2017.
 */

class SnackBarUtils(val context: BaseActivity) {


    public val  actionTextColor: Int = android.R.color.white;

    var snackbar : Snackbar? = null

    fun showSnackBarOnNoInternet() {
        snackbar = Snackbar
                .make(context.findViewById(android.R.id.content), context.getString(R.string.noInternet), Snackbar.LENGTH_INDEFINITE)
                .setAction("Connect") { v -> IntentUtils.connectToWifi(context) }

        // Changing message text color
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            snackbar?.setActionTextColor(context.getColor(actionTextColor))
        } else {
            snackbar?.setActionTextColor(context.resources.getColor(actionTextColor))
        }

        // Changing action button text color
        val sbView = snackbar?.view
        val textView = sbView?.findViewById<TextView>(android.support.design.R.id.snackbar_text) as TextView
        textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_signal_wifi_off, 0, 0, 0)
        textView.compoundDrawablePadding = context.resources.getDimensionPixelOffset(R.dimen.snackbar_icon_padding)

        textView.setTextColor(Color.WHITE)

        snackbar?.show()
    }

    fun hideSnackBar(){
        snackbar?.dismiss()
    }
}
