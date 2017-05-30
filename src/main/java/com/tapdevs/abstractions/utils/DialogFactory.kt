package com.tapdevs.abstractions.utils


import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface

import com.tapdevs.abstractions.R


object DialogFactory {

    fun createSimpleOkErrorDialog(context: Context, message: String): Dialog {
        val alertDialog = AlertDialog.Builder(context)
                .setTitle(context.getString(R.string.dialog_error_title))
                .setMessage(message)
                .setNeutralButton(R.string.dialog_action_ok, null)
        return alertDialog.create()
    }

    fun createRateDialog(context: Context,
                         onClickListener: DialogInterface.OnClickListener): Dialog {
        val rateDialog = AlertDialog.Builder(context).create()
        rateDialog.setTitle(context.getString(R.string.dialog_rate_app_title))
        rateDialog.setMessage(context.getString(R.string.dialog_rate_app_text))
        rateDialog.setButton(AlertDialog.BUTTON_POSITIVE, context.getString(R.string.dialog_positive_button_text), onClickListener)
        rateDialog.setButton(AlertDialog.BUTTON_NEGATIVE, context.getString(R.string.dialog_negative_button_text), onClickListener)
        rateDialog.setButton(AlertDialog.BUTTON_NEUTRAL, context.getString(R.string.dialog_neutral_button_text), onClickListener)
        return rateDialog
    }

}
