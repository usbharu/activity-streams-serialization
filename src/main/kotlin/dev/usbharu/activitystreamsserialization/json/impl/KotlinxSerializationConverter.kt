package dev.usbharu.activitystreamsserialization.json.impl

import dev.usbharu.activitystreamsserialization.json.*
import kotlinx.serialization.json.*
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonNull
import kotlinx.serialization.json.JsonObject


object KotlinxSerializationConverter {
    fun convert(jsonElement: JsonElement): JsonNode {
        return when (jsonElement) {
            is JsonArray -> jsonElement.map { convert(it) }.toJsonArray()
            is JsonObject -> dev.usbharu.activitystreamsserialization.json.JsonObject(jsonElement.map {
                it.key to convert(
                    it.value
                )
            }
                .toMap().toMutableMap())

            is JsonPrimitive -> {
                if (jsonElement.isString) {
                    JsonString(jsonElement.content)
                } else if (jsonElement.booleanOrNull != null) {
                    JsonBoolean(jsonElement.boolean)
                } else if (jsonElement.doubleOrNull != null) {
                    JsonNumber(jsonElement.double)
                } else {
                    JsonString(jsonElement.content)
                }
            }

            JsonNull -> dev.usbharu.activitystreamsserialization.json.JsonNull
        }
    }

    fun convert(jsonNode: JsonNode): JsonElement {
        return when (jsonNode) {
            is JsonString -> JsonPrimitive(jsonNode.value)
            is JsonNumber -> JsonPrimitive(jsonNode.value)
            is JsonBoolean -> JsonPrimitive(jsonNode.value)
            is dev.usbharu.activitystreamsserialization.json.JsonObject -> JsonObject(jsonNode.map {
                it.key to convert(
                    it.value
                )
            }
                .toMap())

            is dev.usbharu.activitystreamsserialization.json.JsonArray -> JsonArray(jsonNode.map { convert(it) })
            else -> JsonNull
        }
    }
}