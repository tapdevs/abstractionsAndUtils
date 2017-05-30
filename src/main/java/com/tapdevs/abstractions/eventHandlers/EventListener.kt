package com.tapdevs.abstractions.eventHandlers

import org.json.JSONObject

/**
 * Created by Jan S. on 15/05/2017.
 */

abstract class EventListener {
    abstract fun receiveEvent(eventName: String, data: JSONObject)
}