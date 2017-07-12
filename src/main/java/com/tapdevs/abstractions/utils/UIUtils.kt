package com.mettle_studio.youtoggle.abstractions.utils

import android.content.Context
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.view.inputmethod.InputMethodManager
import android.widget.EditText


/**
 * Created by ${ Jan Shair } on 29/06/2017.
 */

object UIUtils {

    fun showSoftKeybord(context: Context, editText: EditText){
        val imm = context.getSystemService(
                Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(editText, InputMethodManager.RESULT_SHOWN)

        if(!imm.isActive){
            editText.performClick()
        }
    }



}