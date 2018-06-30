package com.tapdevs.abstractions.utils

import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class DateUtilTest{

    @Test
    fun setTimeString_getFormattedTime_Verify(){
        assertEquals(1486506254000,DateUtil().getMillisFromString("2017-02-07T22:24:14"))
        assertEquals("07 February 2017 22:24",DateUtil().getDateAndTimeFromString("2017-02-07T22:24:14"))
    }
}