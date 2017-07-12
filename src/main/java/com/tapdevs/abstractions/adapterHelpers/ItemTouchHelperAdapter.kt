package com.tapdevs.abstractions.adapterHelpers

/**
 * Created by ${ Jan Shair } on 05/07/2017.
 */

interface ItemTouchHelperAdapter {

    fun onItemMove(fromPosition: Int, toPosition: Int) : Boolean

    fun onItemDismiss(position: Int)
}