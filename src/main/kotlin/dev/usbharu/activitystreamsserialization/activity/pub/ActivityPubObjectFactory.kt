package dev.usbharu.activitystreamsserialization.activity.pub

import dev.usbharu.activitystreamsserialization.json.JsonNode
import dev.usbharu.activitystreamsserialization.other.JsonLd
import dev.usbharu.activitystreamsserialization.other.ObjectFactory

object ActivityPubObjectFactory : ObjectFactory {
    override fun create(jsonNode: JsonNode): JsonLd {
        return DefaultActivityPub(this, jsonNode)
    }
}