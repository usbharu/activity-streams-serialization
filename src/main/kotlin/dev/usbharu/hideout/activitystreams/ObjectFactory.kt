package dev.usbharu.hideout.activitystreams

import dev.usbharu.hideout.activitystreams.json.JsonNode

interface ObjectFactory {
    fun create(jsonNode: JsonNode): JsonLd
}