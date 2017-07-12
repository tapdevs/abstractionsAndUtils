package com.mettle_studio.youtoggle.abstractions.utils

import android.content.Context
import android.location.Address
import android.location.Geocoder
import android.location.Location
import timber.log.Timber
import java.io.IOException

/**
 * Created by ${ Jan Shair } on 06/07/2017.
 */

object AddressUtil{

    fun getAddress(context: Context,location: Location) : String{
        try {
            location.let {
                val geoCoder = Geocoder(context)

                val matches = geoCoder.getFromLocation(location.latitude, location.longitude, 1)

                val bestMatch: Address? = if (matches.isEmpty()) null else matches[0]

                bestMatch?.let {
                    val name: String = "${bestMatch.featureName} ${bestMatch.thoroughfare}, ${bestMatch.postalCode}"

                    return name
                }
            }
        }catch (ex : IOException){
            Timber.d("Service not available to get address")
        }

        return "name not found"
    }
}