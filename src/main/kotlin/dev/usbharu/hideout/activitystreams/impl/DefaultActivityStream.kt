package dev.usbharu.hideout.activitystreams.impl

import dev.usbharu.hideout.activitystreams.LangString
import dev.usbharu.hideout.activitystreams.ObjectOrLink
import dev.usbharu.hideout.activitystreams.json.JsonNode
import java.time.OffsetDateTime

class DefaultActivityStream(override var json: JsonNode) : AbstractActivityStream() {
    override fun toString(): String {
        return "DefaultActivityStream(json=$json)"
    }
}