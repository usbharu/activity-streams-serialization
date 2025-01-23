package dev.usbharu.activitystreamsserialization.other

import dev.usbharu.activitystreamsserialization.json.JsonNode
import dev.usbharu.activitystreamsserialization.model.Properties
import dev.usbharu.activitystreamsserialization.model.core.ObjectOrLinkOrDateTimeOrBoolean
import java.time.OffsetDateTime

class DataTime(override var json: JsonNode) : ObjectOrLinkOrDateTimeOrBoolean {
    override var objectFactory: ObjectFactory
        get() = TODO("Not yet implemented")
        set(value) {}

    fun asDataTime(): OffsetDateTime? {
        return OffsetDateTime.parse(jsonObject[Properties.VALUE]?.asStringLiteralOrNull()?.value ?: return null)
    }
}