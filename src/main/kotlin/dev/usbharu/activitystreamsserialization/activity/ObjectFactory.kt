package dev.usbharu.activitystreamsserialization.activity

import dev.usbharu.activitystreamsserialization.json.JsonNode
import dev.usbharu.activitystreamsserialization.json.JsonObject

interface ObjectFactory {
    fun create(jsonNode: JsonNode): JsonLd
}

inline fun <reified T : JsonLd> ObjectFactory.create(type: String): T {
    val create = this.create(JsonObject(mutableMapOf()))
    create.type += type
    return create.asTypeOfNull<T>(type) as T
}