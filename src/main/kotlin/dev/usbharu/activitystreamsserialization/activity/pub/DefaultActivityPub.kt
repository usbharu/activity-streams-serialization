package dev.usbharu.activitystreamsserialization.activity.pub

import dev.usbharu.activitystreamsserialization.json.JsonNode
import dev.usbharu.activitystreamsserialization.other.ObjectFactory

class DefaultActivityPub(
    override var objectFactory: ObjectFactory = ActivityPubObjectFactory,
    override var json: JsonNode
) : AbstractActivityPub() {
}