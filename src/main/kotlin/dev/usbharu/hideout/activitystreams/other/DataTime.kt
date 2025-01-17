package dev.usbharu.hideout.activitystreams.other

import dev.usbharu.hideout.activitystreams.ObjectFactory
import dev.usbharu.hideout.activitystreams.Properties
import dev.usbharu.hideout.activitystreams.core.ObjectOrLinkOrDateTimeOrBoolean
import dev.usbharu.hideout.activitystreams.json.JsonNode
import java.time.OffsetDateTime

class DataTime(override var json: JsonNode) : ObjectOrLinkOrDateTimeOrBoolean {
    override var objectFactory: ObjectFactory
        get() = TODO("Not yet implemented")
        set(value) {}

    fun asDataTime(): OffsetDateTime? {
        return OffsetDateTime.parse(jsonObject[Properties.VALUE]?.asStringLiteralOrNull()?.value ?: return null)
    }
}