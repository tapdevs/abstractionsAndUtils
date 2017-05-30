package com.tapdevs.abstractions.utils


import com.tapdevs.abstractions.eventHandlers.NetworkStatus

/**
 * Created by  Jan Shair on 31/01/2017.
 */

object AppConstants {

    val SERVER_URL = "https://api.github.com/"


    //Keys
    val USER_OBJECT_PARCELABLE_KEY = "user_profile"
    val BROWSE_FRAGMENT_TAG = "BROWSE_FRAGMENT_TAG"

    //Network Status
    var networkStatus: NetworkStatus? = null
}
