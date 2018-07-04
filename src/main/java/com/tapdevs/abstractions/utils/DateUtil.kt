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

    public fun convertDateStringToCalendatObject(dateStr: String): Calendar {
        val date : Date = SimpleDateFormat(mDateFormat).parse(dateStr)
        val calendar : Calendar = Calendar.getInstance()
        calendar.time= date
        return calendar

    }

    public fun getMillisFromString(input: String) : Long{

        val date = SimpleDateFormat(mDateFormat).parse(input)
        return date.time

    }

    fun getCurrentDate(): String {
        val format = SimpleDateFormat(uiDateFormat)
        return format.format(Date())

    }

    fun getDateTimeStringFromMillis(currentTimeMillis: Long): String {
        val date = SimpleDateFormat(mDateFormat)
        return date.format(Date(currentTimeMillis))
    }
}