package com.tapdevs.abstractions.utils

import android.content.Context
import android.content.Intent
import android.net.Uri



/**
 * Created by ${ Jan Shair } on 29/06/2017.
 */

object ShareUtils{

    fun shareImageAndText(context: Context, text:String, imagePath: String){
        val shareIntent = Intent()
        shareIntent.action = Intent.ACTION_SEND
        shareIntent.putExtra(Intent.EXTRA_TEXT, "Hello")
        shareIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse(imagePath))
        shareIntent.type = "image/jpeg"
        shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        context.startActivity(Intent.createChooser(shareIntent, "send"))
    }
}