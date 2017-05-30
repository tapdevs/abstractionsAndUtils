package com.tapdevs.abstractions.eventHandlers

import android.content.Context

import org.json.JSONObject


/**
 * Created by Jan S. on 15/05/2017.
 */

interface IEvent {
    fun listen(context: Context, eventName: String, listener: EventListener): IEventHandler
    fun post(context: Context, name: String)
    fun post(context: Context, name: String, data: JSONObject)
}
