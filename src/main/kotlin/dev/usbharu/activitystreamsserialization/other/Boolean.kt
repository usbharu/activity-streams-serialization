package dev.usbharu.activitystreamsserialization.other

import dev.usbharu.activitystreamsserialization.activity.ObjectFactory
import dev.usbharu.activitystreamsserialization.activity.Properties
import dev.usbharu.activitystreamsserialization.activity.vocabulary.core.ObjectOrLinkOrDateTimeOrBoolean
import dev.usbharu.activitystreamsserialization.json.JsonNode
import kotlin.Boolean

class Boolean(override var json: JsonNode) : ObjectOrLinkOrDateTimeOrBoolean {
    fun asBoolean(): Boolean? {
        return jsonObject[Properties.VALUE]?.asStringLiteralOrNull()?.value?.toBooleanStrictOrNull()
    }

    override var objectFactory: ObjectFactory
        get() = TODO("Not yet implemented")
        set(value) {}
}