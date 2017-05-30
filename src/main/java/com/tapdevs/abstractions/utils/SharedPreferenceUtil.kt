package com.tapdevs.abstractions.utils

import android.app.Application
import android.content.SharedPreferences
import android.preference.PreferenceManager
import android.text.TextUtils


/**
 * Created by  Jan Shair on 18/02/2017.
 */

class SharedPreferenceUtil(application: Application) {

    private val preferences: SharedPreferences?

    init {
        preferences = PreferenceManager.getDefaultSharedPreferences(application)

    }

    /**
     * Helper method to retrieve a String value from [SharedPreferences].


     * @param key
     * *
     * @return The value from shared preferences, or null if the value could not be read.
     */
    fun getStringPreference(key: String): String {
        var value: String? = null

        if (preferences != null) {
            value = preferences.getString(key, null)
        }
        return value!!
    }

    /**
     * Helper method to write a String value to [SharedPreferences].


     * @param key
     * *
     * @param value
     * *
     * @return true if the new value was successfully written to persistent storage.
     */
    fun setStringPreference(key: String, value: String): Boolean {

        if (preferences != null && !TextUtils.isEmpty(key)) {
            val editor = preferences.edit()
            editor.putString(key, value)
            return editor.commit()
        }
        return false
    }

    /**
     * Helper method to retrieve a float value from [SharedPreferences].


     * @param key
     * *
     * @param defaultValue A default to return if the value could not be read.
     * *
     * @return The value from shared preferences, or the provided default.
     */
    fun getFloatPreference(key: String, defaultValue: Float): Float {
        var value = defaultValue

        if (preferences != null) {
            value = preferences.getFloat(key, defaultValue)
        }
        return value
    }

    /**
     * Helper method to write a float value to [SharedPreferences].


     * @param key
     * *
     * @param value
     * *
     * @return true if the new value was successfully written to persistent storage.
     */
    fun setFloatPreference(key: String, value: Float): Boolean {

        if (preferences != null) {
            val editor = preferences.edit()
            editor.putFloat(key, value)
            return editor.commit()
        }
        return false
    }

    /**
     * Helper method to retrieve a long value from [SharedPreferences].


     * @param key
     * *
     * @param defaultValue A default to return if the value could not be read.
     * *
     * @return The value from shared preferences, or the provided default.
     */
    fun getLongPreference(key: String, defaultValue: Long): Long {
        var value = defaultValue

        if (preferences != null) {
            value = preferences.getLong(key, defaultValue)
        }
        return value
    }

    /**
     * Helper method to write a long value to [SharedPreferences].


     * @param key
     * *
     * @param value
     * *
     * @return true if the new value was successfully written to persistent storage.
     */
    fun setLongPreference(key: String, value: Long): Boolean {

        if (preferences != null) {
            val editor = preferences.edit()
            editor.putLong(key, value)
            return editor.commit()
        }
        return false
    }

    /**
     * Helper method to retrieve an integer value from [SharedPreferences].


     * @param key
     * *
     * @param defaultValue A default to return if the value could not be read.
     * *
     * @return The value from shared preferences, or the provided default.
     */
    fun getIntegerPreference(key: String, defaultValue: Int): Int {
        var value = defaultValue

        if (preferences != null) {
            value = preferences.getInt(key, defaultValue)
        }
        return value
    }

    /**
     * Helper method to write an integer value to [SharedPreferences].


     * @param key
     * *
     * @param value
     * *
     * @return true if the new value was successfully written to persistent storage.
     */
    fun setIntegerPreference(key: String, value: Int): Boolean {

        if (preferences != null) {
            val editor = preferences.edit()
            editor.putInt(key, value)
            return editor.commit()
        }
        return false
    }

    /**
     * Helper method to retrieve a boolean value from [SharedPreferences].

     * @param key
     * *
     * @param defaultValue A default to return if the value could not be read.
     * *
     * @return The value from shared preferences, or the provided default.
     */
    fun getBooleanPreference(key: String, defaultValue: Boolean): Boolean {
        var value = defaultValue

        if (preferences != null) {
            value = preferences.getBoolean(key, defaultValue)
        }
        return value
    }

    /**
     * Helper method to write a boolean value to [SharedPreferences].

     * @param key
     * *
     * @param value
     * *
     * @return true if the new value was successfully written to persistent storage.
     */
    fun setBooleanPreference(key: String, value: Boolean): Boolean {
        if (preferences != null) {
            val editor = preferences.edit()
            editor.putBoolean(key, value)
            return editor.commit()
        }
        return false
    }
}
