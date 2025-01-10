package dev.usbharu.hideout.activitystreams

import dev.usbharu.hideout.activitystreams.json.JsonNode
import dev.usbharu.hideout.activitystreams.json.JsonObject
import dev.usbharu.hideout.activitystreams.json.JsonString
import dev.usbharu.hideout.activitystreams.json.toJsonArray
import java.time.OffsetDateTime

interface Object : ObjectOrLink, JsonLd {

    var published: OffsetDateTime?
        get() {
            val jsonNode = jsonObject.obtain("https://www.w3.org/ns/activitystreams#published") ?: return null
            return jsonNode.asArray().mapNotNull {
                require(it.isObject)
                it as JsonObject
                if (it["@type"] != JsonString("http://www.w3.org/2001/XMLSchema#dateTime")) {
                    null
                } else {
                    OffsetDateTime.parse(it["@value"]?.asStringLiteralOrNull()?.value.toString())
                }
            }.first()
        }
        set(value) {
            if (value == null) {
                jsonObject.remove("https://www.w3.org/ns/activitystreams#published")
            }
            jsonObject.setOrRemove(
                "https://www.w3.org/ns/activitystreams#published", listOf(
                    JsonObject(
                        mutableMapOf(
                            "@type" to JsonString("http://www.w3.org/2001/XMLSchema#dateTime"),
                            "@value" to JsonString(
                                value.toString()
                            )
                        )
                    )
                ).toJsonArray()
            )
        }
    var name: List<LangString>
        get() {
            val jsonNode = jsonObject.obtain("https://www.w3.org/ns/activitystreams#name") ?: return emptyList()

            return jsonNode.asArray().map {
                require(it.isObject)
                it as JsonObject
                LangString(
                    it["@language"]?.asStringLiteralOrNull()?.value,
                    it["@value"]!!.asStringLiteralOrNull()?.value.toString()
                )
            }
        }
        set(value) {
            jsonObject.setOrRemove(
                "https://www.w3.org/ns/activitystreams#name",
                value.map { it.toJsonObject() }.toJsonArray()
            )
        }
    var content: List<LangString>
        get() {
            val jsonNode = jsonObject.obtain("https://www.w3.org/ns/activitystreams#content") ?: return emptyList()

            return jsonNode.asArray().map {
                require(it.isObject)
                it as JsonObject
                LangString(
                    it["@language"]?.asStringLiteralOrNull()?.value,
                    it["@value"]!!.asStringLiteralOrNull()?.value.toString()
                )
            }
        }
        set(value) {
            jsonObject.setOrRemove(
                "https://www.w3.org/ns/activitystreams#content",
                value.map { it.toJsonObject() }.toJsonArray()
            )
        }
}