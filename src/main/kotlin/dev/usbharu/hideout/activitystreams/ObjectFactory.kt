package dev.usbharu.hideout.activitystreams

import dev.usbharu.hideout.activitystreams.impl.DefaultActivityStream
import dev.usbharu.hideout.activitystreams.json.JsonNode
import dev.usbharu.hideout.activitystreams.json.JsonObject

object ObjectFactory {
    fun factory(jsonNode: JsonNode): JsonLd {
        return DefaultActivityStream(jsonNode)
    }

    fun toJsonNode(jsonLd: JsonLd): JsonNode {
        return jsonLd.json
    }
}