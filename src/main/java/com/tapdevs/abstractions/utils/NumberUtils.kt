package com.tapdevs.abstractions.utils

import java.text.NumberFormat


object NumberUtils{

    fun limitFloatTo2Decimals(float: Float) : String{
        val numberFormat : NumberFormat = NumberFormat.getNumberInstance().apply {
            minimumFractionDigits = 2
            maximumFractionDigits = 2
        }

        return numberFormat.format(float)

    }
}