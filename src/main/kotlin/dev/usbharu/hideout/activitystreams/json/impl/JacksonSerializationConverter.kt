package dev.usbharu.hideout.activitystreams.json.impl

import com.fasterxml.jackson.databind.node.*
import com.fasterxml.jackson.databind.node.JsonNodeType.*
import dev.usbharu.hideout.activitystreams.json.*

object JacksonSerializationConverter {
    fun convert(jsonNode: com.fasterxml.jackson.databind.JsonNode): JsonNode {
        return when (jsonNode.nodeType) {
            ARRAY -> jsonNode.map { convert(it) }.toJsonArray()
            BINARY -> JsonString(jsonNode.asText())
            BOOLEAN -> JsonBoolean(jsonNode.asBoolean())
            MISSING -> JsonNull
            NULL -> JsonNull
            NUMBER -> JsonNumber(jsonNode.asDouble())
            OBJECT -> JsonObject(
                jsonNode.fields().asSequence().map { it.key to convert(it.value) }.toMap().toMutableMap()
            )

            POJO -> JsonString(jsonNode.asText())
            STRING -> JsonString(jsonNode.textValue())
            null -> JsonNull
        }
    }

    fun convert(jsonNode: JsonNode): com.fasterxml.jackson.databind.JsonNode {
        return when (jsonNode) {
            is JsonString -> TextNode(jsonNode.value)
            is JsonNumber -> DoubleNode(jsonNode.value)
            is JsonBoolean -> BooleanNode.valueOf(jsonNode.value)
            is JsonObject -> ObjectNode(JsonNodeFactory(false), jsonNode.map {
                it.key to convert(
                    it.value
                )
            }.toMap())

            is dev.usbharu.hideout.activitystreams.json.JsonArray -> ArrayNode(JsonNodeFactory(false), jsonNode.map {
                convert(it)
            })

            else -> NullNode.instance
        }
    }
}