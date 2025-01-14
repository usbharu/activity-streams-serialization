package dev.usbharu.hideout.activitystreams

import dev.usbharu.hideout.activitystreams.Properties.ID
import dev.usbharu.hideout.activitystreams.json.JsonNode
import dev.usbharu.hideout.activitystreams.json.JsonObject
import dev.usbharu.hideout.activitystreams.json.JsonString
import dev.usbharu.hideout.activitystreams.json.toJsonArray
import java.net.URI

interface JsonLd {
    var objectFactory:ObjectFactory
    var json: JsonNode
    val jsonObject: JsonObject
        get() {
            require(json.isObject)
            return json as JsonObject
        }
    var type: List<String>
        get() {
            return jsonObject[Properties.TYPE]?.asArray()?.mapNotNull { it.asStringLiteralOrNull()?.value }
                ?: return emptyList()
        }
        set(value) {
            return jsonObject.setOrRemove(Properties.TYPE, value.mapNotNull(JsonString::create).toJsonArray())
        }
    var id: URI?
        get() {
            val string = jsonObject.obtain(ID)?.asStringLiteralOrNull() ?: return null
            return URI.create(string.value)
        }
        set(value) {
            jsonObject.setOrRemove(ID, JsonString.create(value?.toString()))
        }

    fun getAsObjectOrLink(id: String, objectFactory: ObjectFactory = this.objectFactory): List<ObjectOrLink> {
        val jsonNode = jsonObject.obtain(id) ?: return emptyList()
        return jsonNode.asArray().map { objectFactory.create(it) as ObjectOrLink }
    }

    fun setAsObjectOrLink(id: String, `object`: List<ObjectOrLink>) {
        jsonObject.setOrRemove(
            id,
            `object`.map { DefaultObjectFactory.toJsonNode(it) }.toJsonArray()
        )
    }
}

inline fun <reified T : JsonLd> JsonLd.asTypeOfNull(type: String): T? {
    if (this.type.contains(type).not()) {
        return null
    }
    return this as? T
}