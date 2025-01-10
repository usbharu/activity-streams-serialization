package dev.usbharu.hideout.activitystreams.json.impl

import dev.usbharu.hideout.activitystreams.json.JsonLiteral
import dev.usbharu.hideout.activitystreams.json.JsonNode
import dev.usbharu.hideout.activitystreams.json.JsonString
import dev.usbharu.hideout.activitystreams.json.toJsonArray
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.*


object KotlinxSerializationImpl {
    fun convert(jsonElement: JsonElement): JsonNode {
        return when (jsonElement) {
            is JsonArray -> jsonElement.map { convert(it) }.toJsonArray()
            is JsonObject -> dev.usbharu.hideout.activitystreams.json.JsonObject(jsonElement.map { it.key to convert(it.value) }
                .toMap().toMutableMap())

            is JsonPrimitive -> JsonString(jsonElement.content) //todo ちゃんと型を見る
            JsonNull -> dev.usbharu.hideout.activitystreams.json.JsonNull
        }
    }
}