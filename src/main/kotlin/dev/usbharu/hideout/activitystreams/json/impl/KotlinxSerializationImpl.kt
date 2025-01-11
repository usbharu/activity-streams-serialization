package dev.usbharu.hideout.activitystreams.json.impl

import dev.usbharu.hideout.activitystreams.json.*
import kotlinx.serialization.json.*
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonNull
import kotlinx.serialization.json.JsonObject


object KotlinxSerializationImpl {
    fun convert(jsonElement: JsonElement): JsonNode {
        return when (jsonElement) {
            is JsonArray -> jsonElement.map { convert(it) }.toJsonArray()
            is JsonObject -> dev.usbharu.hideout.activitystreams.json.JsonObject(jsonElement.map { it.key to convert(it.value) }
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

            JsonNull -> dev.usbharu.hideout.activitystreams.json.JsonNull
        }
    }
}