package com.tapdevs.abstractions.listeners

/**
 * Created by ${ Jan Shair } on 26/06/2017.
 */

interface IPermissionListener{

    fun onRequestPermissionsResultsReceived(requestCode: Int, permissions: Array<out String>, grantResults: IntArray)
}