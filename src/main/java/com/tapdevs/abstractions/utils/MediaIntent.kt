package com.mettle_studio.youtoggle.abstractions.utils

import com.mettle_studio.youtoggle.enums.FileType
import java.net.URLConnection
import java.net.URLConnection.guessContentTypeFromName



/**
 * Created by ${ Jan Shair } on 28/06/2017.
 */

object MediaIntent{

    fun isImageFile(path: String): Boolean {
        val mimeType = URLConnection.guessContentTypeFromName(path)
        return mimeType != null && mimeType!!.startsWith("image")
    }


    fun isVideoFile(path: String): Boolean {
        val mimeType = URLConnection.guessContentTypeFromName(path)
        return mimeType != null && mimeType.startsWith("video")
    }

    fun isVideoOrPhoto(path: String) : Int{
        if(MediaIntent.isImageFile(path)){
            return  FileType.PHOTO
        }else if(MediaIntent.isVideoFile(path)){
            return  FileType.VIDEO
        }

        return FileType.NO_FILE
    }
}