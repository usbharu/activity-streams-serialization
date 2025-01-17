package dev.usbharu.hideout.activitystreams.other

import dev.usbharu.hideout.activitystreams.ObjectFactory
import dev.usbharu.hideout.activitystreams.Properties
import dev.usbharu.hideout.activitystreams.core.ObjectOrLinkOrDateTimeOrBoolean
import dev.usbharu.hideout.activitystreams.json.JsonNode
import kotlin.Boolean

class Boolean(override var json: JsonNode) : ObjectOrLinkOrDateTimeOrBoolean {
    fun asBoolean(): Boolean? {
        return jsonObject[Properties.VALUE]?.asStringLiteralOrNull()?.value?.toBooleanStrictOrNull()
    }

    override var objectFactory: ObjectFactory
        get() = TODO("Not yet implemented")
        set(value) {}
}