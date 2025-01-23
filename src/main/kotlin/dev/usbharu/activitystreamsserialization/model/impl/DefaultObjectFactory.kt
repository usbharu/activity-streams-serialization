package dev.usbharu.activitystreamsserialization.model.impl

import dev.usbharu.activitystreamsserialization.json.JsonNode
import dev.usbharu.activitystreamsserialization.other.JsonLd
import dev.usbharu.activitystreamsserialization.other.ObjectFactory

object DefaultObjectFactory : ObjectFactory {
    override fun create(jsonNode: JsonNode): JsonLd {
        return DefaultActivityVocabulary(jsonNode, this)
    }

}