package dev.usbharu.hideout.activitystreams

import dev.usbharu.hideout.activitystreams.json.JsonNode
import dev.usbharu.hideout.activitystreams.json.JsonObject
import dev.usbharu.hideout.activitystreams.json.JsonString
import dev.usbharu.hideout.activitystreams.json.toJsonArray
import java.net.URI

interface JsonLd {
    var json: JsonNode
    val jsonObject: JsonObject
        get() {
            require(json.isObject)
            return json as JsonObject
        }
    var type: List<String>
        get() {
            return jsonObject["@type"]?.asArray()?.mapNotNull { it.asStringLiteralOrNull()?.value }
                ?: return emptyList()
        }
        set(value) {
            return jsonObject.setOrRemove("@type", value.map { JsonString(it) }.toJsonArray())
        }
    var id: URI?
        get() {
            val string = jsonObject.obtain("@id")?.asStringLiteralOrNull() ?: return null
            return URI.create(string.value)
        }
        set(value) {
            jsonObject.setOrRemove("@id", value?.toString()?.let { JsonString(it) })
        }

    fun getAsObjectOrLink(id: String): List<ObjectOrLink> {
        val jsonNode = jsonObject.obtain(id) ?: return emptyList()
        return jsonNode.asArray().map { ObjectFactory.factory(it) as ObjectOrLink }
    }

    fun setAsObjectOrLink(id: String, `object`: List<ObjectOrLink>) {
        jsonObject.setOrRemove(
            id,
            `object`.map { ObjectFactory.toJsonNode(it) }.toJsonArray()
        )
    }
}