package com.tapdevs.abstractions.utils

import java.text.DecimalFormat
import java.text.NumberFormat


object NumberUtils {

    fun limitFloatTo2Decimals(float: Float): String {
        val numberFormat: NumberFormat = NumberFormat.getNumberInstance().apply {
            minimumFractionDigits = 2
            maximumFractionDigits = 2
        }

        return numberFormat.format(float)

    }

    fun limitFloatTo2DecimalsPoints(float: Float): Float {
        val decimalFormat : DecimalFormat =  DecimalFormat("0.00")
        return decimalFormat.format(float).toFloat()

    }
}