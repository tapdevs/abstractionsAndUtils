package com.tapdevs.abstractions.utils

import org.junit.Test

import org.junit.Assert.*

class TextUtilsTest {

    @Test
    fun convertStringToUpperCase_Verify() {
        assertEquals("Apple",TextUtils.convertStringToUpperCase("apple"))
        assertEquals("",TextUtils.convertStringToUpperCase(""))
        assertEquals("1app",TextUtils.convertStringToUpperCase("1app"))
        assertEquals("Aapp",TextUtils.convertStringToUpperCase("Aapp"))
    }
}