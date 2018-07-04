package com.tapdevs.abstractions.utils

import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.util.*

@RunWith(JUnit4::class)
class DateUtilTest{

    @Test
    fun setTimeString_getFormattedTime_Verify(){
        assertEquals(1486506254000,DateUtil().getMillisFromString("2017-02-07T22:24:14"))
        assertEquals("07 February 2017 22:24",DateUtil().getDateAndTimeFromString("2017-02-07T22:24:14"))
    }

    @Test
    fun setMills_getDate_Verify() {
        assertEquals( "2017-02-07T22:24:14",DateUtil().getDateTimeStringFromMillis(1486506254000))
    }

    @Test
    fun setDateString_covertToCalendarObject_Verify() {
        val calendar : Calendar = DateUtil().convertDateStringToCalendatObject("2017-02-07T22:24:14")
        assertEquals(7,calendar.get(Calendar.DAY_OF_MONTH))
        assertEquals(2,calendar.get(Calendar.MONTH).plus(1))
        assertEquals(2017,calendar.get(Calendar.YEAR))
        assertEquals(22,calendar.get(Calendar.HOUR_OF_DAY))
        assertEquals(10,calendar.get(Calendar.HOUR))
        assertEquals(24,calendar.get(Calendar.MINUTE))
        assertEquals(14,calendar.get(Calendar.SECOND))
    }
}