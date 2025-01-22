package dev.usbharu.activitystreamsserialization.activity.vocabulary.`object`

import dev.usbharu.activitystreamsserialization.activity.Properties
import dev.usbharu.activitystreamsserialization.activity.vocabulary.core.Object
import dev.usbharu.activitystreamsserialization.json.JsonNull
import dev.usbharu.activitystreamsserialization.json.JsonNumber
import dev.usbharu.activitystreamsserialization.json.JsonString
import dev.usbharu.activitystreamsserialization.other.Units
import dev.usbharu.activitystreamsserialization.other.Uri
import dev.usbharu.activitystreamsserialization.other.UriOrUnits


interface Place : Object {
    var accuracy: Float?
        get() = jsonObject.obtain(Properties.ACCURACY)?.asArray()?.firstOrNull()?.asObjectOrNull()
            ?.obtain(Properties.VALUE)?.asNumberLiteralOrNull()?.value?.toFloat()
        set(value) = jsonObject.setOrRemove(Properties.ACCURACY, value?.let { JsonNumber(it.toDouble()) })
    var altitude: Float?
        get() = jsonObject.obtain(Properties.ALTITUDE)?.asArray()?.firstOrNull()?.asObjectOrNull()
            ?.obtain(Properties.VALUE)?.asNumberLiteralOrNull()?.value?.toFloat()
        set(value) = jsonObject.setOrRemove(Properties.ALTITUDE, value?.let { JsonNumber(it.toDouble()) })
    var latitude: Float?
        get() = jsonObject.obtain(Properties.LATITUDE)?.asArray()?.firstOrNull()?.asObjectOrNull()
            ?.obtain(Properties.VALUE)?.asNumberLiteralOrNull()?.value?.toFloat()
        set(value) = jsonObject.setOrRemove(Properties.LATITUDE, value?.let { JsonNumber(it.toDouble()) })
    var longitude: Float?
        get() = jsonObject.obtain(Properties.LONGITUDE)?.asArray()?.firstOrNull()?.asObjectOrNull()
            ?.obtain(Properties.VALUE)?.asNumberLiteralOrNull()?.value?.toFloat()
        set(value) = jsonObject.setOrRemove(Properties.LONGITUDE, value?.let { JsonNumber(it.toDouble()) })
    var radius: Float?
        get() = jsonObject.obtain(Properties.RADIUS)?.asArray()?.firstOrNull()?.asObjectOrNull()
            ?.obtain(Properties.VALUE)?.asNumberLiteralOrNull()?.value?.toFloat()
        set(value) = jsonObject.setOrRemove(Properties.RADIUS, value?.let { JsonNumber(it.toDouble()) })
    var units: UriOrUnits?
        get() {
            val jsonNode = jsonObject.obtain(Properties.UNITS)?.asArray()?.firstOrNull() ?: return null
            val string = jsonNode.asObjectOrNull()
                ?.obtain(Properties.VALUE)?.asStringLiteralOrNull()?.value ?: return null

            return when (string) {
                "cm" -> Units.cm
                "feet" -> Units.feet
                "inches" -> Units.inches
                "km" -> Units.km
                "m" -> Units.m
                "miles" -> Units.miles
                else -> Uri(jsonNode)
            }
        }
        set(value) = jsonObject.setOrRemove(Properties.UNITS, value?.let {
            when (it) {
                is Units -> JsonString(it.name)
                is Uri -> it.json
                else -> JsonNull
            }
        })
}