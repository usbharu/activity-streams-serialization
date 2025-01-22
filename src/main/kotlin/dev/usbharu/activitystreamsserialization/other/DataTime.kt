package dev.usbharu.activitystreamsserialization.other

import dev.usbharu.activitystreamsserialization.activity.Properties
import dev.usbharu.activitystreamsserialization.activity.vocabulary.core.ObjectOrLinkOrDateTimeOrBoolean
import dev.usbharu.activitystreamsserialization.json.JsonNode
import java.time.OffsetDateTime

class DataTime(override var json: JsonNode) : ObjectOrLinkOrDateTimeOrBoolean {
    override var objectFactory: ObjectFactory
        get() = TODO("Not yet implemented")
        set(value) {}

    fun asDataTime(): OffsetDateTime? {
        return OffsetDateTime.parse(jsonObject[Properties.VALUE]?.asStringLiteralOrNull()?.value ?: return null)
    }
}