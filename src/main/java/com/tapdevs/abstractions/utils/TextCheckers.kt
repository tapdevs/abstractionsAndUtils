package com.tapdevs.abstractions.utils

import java.util.regex.Matcher
import java.util.regex.Pattern

/**
 * Created by  Jan Shair on 03/02/2017.
 */

object TextCheckers {

    fun isEmailValid(email: String): Boolean {
        var isValid = false

        val expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"
        val inputStr = email

        val pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
        val matcher = pattern.matcher(inputStr)
        if (matcher.matches()) {
            isValid = true
            return isValid
        }

        return isValid

    }

    fun isPasswordValid(password: String): Boolean {
        //TODO: Replace this with your own logic
        return password.trim { it <= ' ' }.length > 5
    }
}
