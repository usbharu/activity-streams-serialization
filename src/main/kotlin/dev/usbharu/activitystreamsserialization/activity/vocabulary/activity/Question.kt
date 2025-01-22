package dev.usbharu.activitystreamsserialization.activity.vocabulary.activity

import dev.usbharu.activitystreamsserialization.activity.Properties
import dev.usbharu.activitystreamsserialization.activity.vocabulary.core.IntransitiveActivity
import dev.usbharu.activitystreamsserialization.activity.vocabulary.core.ObjectOrLink
import dev.usbharu.activitystreamsserialization.activity.vocabulary.core.ObjectOrLinkOrDateTimeOrBoolean
import dev.usbharu.activitystreamsserialization.json.JsonObject
import dev.usbharu.activitystreamsserialization.json.toJsonArray
import dev.usbharu.activitystreamsserialization.other.Boolean
import dev.usbharu.activitystreamsserialization.other.DataTime

interface Question : IntransitiveActivity {
    var oneOf: List<ObjectOrLink>
        get() = getAsObjectOrLink(Properties.ONE_OF)
        set(value) = setAsObjectOrLink(Properties.ONE_OF, value)
    var anyOf: List<ObjectOrLink>
        get() = getAsObjectOrLink(Properties.ANY_OF)
        set(value) = setAsObjectOrLink(Properties.ANY_OF, value)
    var closed: List<ObjectOrLinkOrDateTimeOrBoolean>
        get() {
            val jsonNode = jsonObject.obtain(Properties.CLOSED) ?: return emptyList()
            return jsonNode.asArray().map {
                require(it.isObject)
                it as JsonObject
                if (it[Properties.TYPE] != null) {
                    objectFactory.create(it) as ObjectOrLinkOrDateTimeOrBoolean
                } else {
                    val b = it[Properties.VALUE]?.asStringLiteralOrNull()?.value?.toBooleanStrictOrNull()
                    if (b != null) {
                        Boolean(it)
                    } else {
                        DataTime(it)
                    }
                }
            }
        }
        set(value) {
            jsonObject.setOrRemove(
                Properties.CLOSED,
                value.map { it.json }.toJsonArray()
            )
        }
}