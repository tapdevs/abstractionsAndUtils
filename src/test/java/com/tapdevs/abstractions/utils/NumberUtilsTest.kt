package com.tapdevs.abstractions.utils

import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class NumberUtilsTest {

    @Test
    fun limitFloatTo2Decimals() {
        assertEquals("2.33",NumberUtils.limitFloatTo2Decimals(2.333333333333f))
    }

    @Test
    fun setValue_limitFloatTo2DecimalsPoints_Verify() {
        assertEquals(1.29f,NumberUtils.limitFloatTo2DecimalsPoints(1.293489384902f))
    }

    @Test
    fun containsNumberOrDigits_Verify() {
        assertEquals(false,NumberUtils.containsNumberOrDigits("."))
        assertEquals(true,NumberUtils.containsNumberOrDigits("1."))
        assertEquals(false,NumberUtils.containsNumberOrDigits("aaaa."))
        assertEquals(false,NumberUtils.containsNumberOrDigits("bbbb."))
    }
}