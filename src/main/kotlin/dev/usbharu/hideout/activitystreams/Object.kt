package dev.usbharu.hideout.activitystreams

import dev.usbharu.hideout.activitystreams.json.JsonObject
import dev.usbharu.hideout.activitystreams.json.JsonString
import dev.usbharu.hideout.activitystreams.json.toJsonArray
import java.time.OffsetDateTime

interface Object : ObjectOrLink, JsonLd {

    var published: OffsetDateTime?
        get() {
            val jsonNode = jsonObject.obtain(Properties.PUBLISHED) ?: return null
            return jsonNode.asArray().firstNotNullOf {
                require(it.isObject)
                it as JsonObject
                if (it[Properties.TYPE] != JsonString("http://www.w3.org/2001/XMLSchema#dateTime")) {
                    null
                } else {
                    OffsetDateTime.parse(it[Properties.VALUE]?.asStringLiteralOrNull()?.value.toString())
                }
            }
        }
        set(value) {
            if (value == null) {
                jsonObject.remove(Properties.PUBLISHED)
            }
            jsonObject.setOrRemove(
                Properties.PUBLISHED, listOf(
                    JsonObject(
                        mutableMapOf(
                            Properties.TYPE to JsonString("http://www.w3.org/2001/XMLSchema#dateTime"),
                            Properties.VALUE to JsonString(
                                value.toString()
                            )
                        )
                    )
                ).toJsonArray()
            )
        }
    var name: List<LangString>
        get() {
            val jsonNode = jsonObject.obtain(Properties.NAME) ?: return emptyList()

            return jsonNode.asArray().map {
                require(it.isObject)
                it as JsonObject
                LangString(
                    it[Properties.LANGUAGE]?.asStringLiteralOrNull()?.value,
                    it[Properties.VALUE]!!.asStringLiteralOrNull()?.value.toString()
                )
            }
        }
        set(value) {
            jsonObject.setOrRemove(
                Properties.NAME,
                value.map { it.toJsonObject() }.toJsonArray()
            )
        }
    var content: List<LangString>
        get() {
            val jsonNode = jsonObject.obtain(Properties.CONTENT) ?: return emptyList()

            return jsonNode.asArray().map {
                require(it.isObject)
                it as JsonObject
                LangString(
                    it[Properties.LANGUAGE]?.asStringLiteralOrNull()?.value,
                    it[Properties.VALUE]!!.asStringLiteralOrNull()?.value.toString()
                )
            }
        }
        set(value) {
            jsonObject.setOrRemove(
                Properties.CONTENT,
                value.map { it.toJsonObject() }.toJsonArray()
            )
        }
}