package com.tapdevs.abstractions.utils

import com.tapdevs.abstractions.enums.FileType
import java.net.URLConnection


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
        if(isImageFile(path)){
            return FileType.PHOTO
        }else if(isVideoFile(path)){
            return FileType.VIDEO
        }

        return FileType.NO_FILE
    }
}