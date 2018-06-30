package com.tapdevs.abstractions.utils

import java.text.SimpleDateFormat
import java.util.*


/**
 * Created by ${ Jan Shair } on 29/06/2017.
 */

class DateUtil{

    var mDateFormat: String = "yyyy-MM-dd'T'HH:mm:ss"
    var uiDateFormat: String = "dd MMMM YYYY HH:mm"
    constructor()

    constructor(dateFormat: String){
        mDateFormat = dateFormat
    }

    public fun getDateAndTimeFromString(date: String):String{
        val format = SimpleDateFormat(uiDateFormat)
        return format.format(Date(getMillisFromString(date)))

    }

    public fun getMillisFromString(input: String) : Long{

        val date = SimpleDateFormat(mDateFormat).parse(input)
        return date.time

    }

    fun getCurrentDate(): String {
        val format = SimpleDateFormat(uiDateFormat)
        return format.format(Date())

    }

    fun getDateAndTimeFromMillis(currentTimeMillis: Long): String {
        return ""

    }
}