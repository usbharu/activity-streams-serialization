package dev.usbharu.hideout.activitystreams.activity

import dev.usbharu.hideout.activitystreams.Properties
import dev.usbharu.hideout.activitystreams.core.IntransitiveActivity
import dev.usbharu.hideout.activitystreams.core.ObjectOrLink
import dev.usbharu.hideout.activitystreams.core.ObjectOrLinkOrDateTimeOrBoolean
import dev.usbharu.hideout.activitystreams.json.JsonObject
import dev.usbharu.hideout.activitystreams.json.toJsonArray
import dev.usbharu.hideout.activitystreams.other.Boolean
import dev.usbharu.hideout.activitystreams.other.DataTime

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