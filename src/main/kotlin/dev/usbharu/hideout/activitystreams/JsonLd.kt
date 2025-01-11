package dev.usbharu.hideout.activitystreams

import dev.usbharu.hideout.activitystreams.Properties.ID
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
            return jsonObject[Properties.TYPE]?.asArray()?.mapNotNull { it.asStringLiteralOrNull()?.value }
                ?: return emptyList()
        }
        set(value) {
            return jsonObject.setOrRemove(Properties.TYPE, value.map { JsonString(it) }.toJsonArray())
        }
    var id: URI?
        get() {
            val string = jsonObject.obtain(ID)?.asStringLiteralOrNull() ?: return null
            return URI.create(string.value)
        }
        set(value) {
            jsonObject.setOrRemove(ID, value?.toString()?.let { JsonString(it) })
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

fun <T : JsonLd> JsonLd.asTypeOrNull(clazz: Class<T>): T? {
    return this as? T
}

inline fun <reified T : JsonLd> JsonLd.asTypeOfNull(type: String): T? {
    if (this.type.contains(type).not()) {
        return null
    }
    return this as? T
}