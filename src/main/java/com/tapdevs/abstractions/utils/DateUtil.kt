package com.mettle_studio.youtoggle.abstractions.utils

import android.text.format.DateFormat
import java.text.SimpleDateFormat
import java.util.*


/**
 * Created by ${ Jan Shair } on 29/06/2017.
 */

object DateUtil{

    fun getCurrentTimeInDDmonthYYFormat(): String {
        return getTimeInDDmonthYYFormat(System.currentTimeMillis())
    }



    fun getTimeInDDmonthYYFormat(timeInMillis: Long): String {
        return convertDate(timeInMillis,"dd MMMM yyyy");

    }

    fun convertDate(dateInMilliseconds: Long, dateFormat: String): String {
        return DateFormat.format(dateFormat, dateInMilliseconds).toString()
    }

    fun getCurrentDate(): String {
        // Create a DateFormatter object for displaying date in specified format.
        val formatter = SimpleDateFormat("dd_MM_yyyy")

        // Create a calendar object that will convert the date and time value in milliseconds to date.
        val calendar = Calendar.getInstance()
        calendar.setTimeInMillis(System.currentTimeMillis())
        return formatter.format(calendar.getTime())
    }

    fun getDateAndTimeFromMillis(timeInMillis : Long): String {
        // Create a DateFormatter object for displaying date in specified format.
        val formatter = SimpleDateFormat("dd/MM/yyyy HH:mm:ss")

        // Create a calendar object that will convert the date and time value in milliseconds to date.
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = timeInMillis
        return formatter.format(calendar.time)
    }
}