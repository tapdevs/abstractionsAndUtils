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
}