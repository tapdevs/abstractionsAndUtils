package com.tapdevs.abstractions.utils

object TextUtils{

    fun convertStringToUpperCase(value: String) : String{
        return if(value.length == 0) "" else "${value[0].toUpperCase()}${value.substring(1)}"
    }
}