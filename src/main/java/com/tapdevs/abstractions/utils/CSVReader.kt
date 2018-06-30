package com.tapdevs.abstractions.utils

import android.content.Context
import android.content.res.AssetManager
import java.io.*
import java.nio.charset.Charset


class CSVReader(val context: Context, val name : String){

    @Throws(UnsupportedEncodingException::class)
    public fun getReader():ArrayList<String> {

        val assetManager = context.assets
        var `is`: InputStream? = null

        try {
            `is` = assetManager.open(name)
        } catch (e: IOException) {
            // TODO Auto-generated catch block
            e.printStackTrace()
        }


        var reader: BufferedReader? = null
        reader = BufferedReader(InputStreamReader(`is`, Charset.forName("UTF-8")))
        val strings : ArrayList<String> = ArrayList<String>()
        strings.addAll(reader.readLines())
        return strings

    }
}