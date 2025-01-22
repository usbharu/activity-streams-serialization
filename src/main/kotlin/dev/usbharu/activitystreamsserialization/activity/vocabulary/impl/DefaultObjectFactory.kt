package dev.usbharu.activitystreamsserialization.activity.vocabulary.impl

import dev.usbharu.activitystreamsserialization.activity.JsonLd
import dev.usbharu.activitystreamsserialization.activity.ObjectFactory
import dev.usbharu.activitystreamsserialization.json.JsonNode

object DefaultObjectFactory : ObjectFactory {
    override fun create(jsonNode: JsonNode): JsonLd {
        return DefaultActivityStream(jsonNode, this)
    }

}