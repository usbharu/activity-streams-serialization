package dev.usbharu.activitystreamsserialization.other


import dev.usbharu.activitystreamsserialization.json.JsonNode
import dev.usbharu.activitystreamsserialization.json.JsonObject
import dev.usbharu.activitystreamsserialization.json.JsonString
import dev.usbharu.activitystreamsserialization.json.toJsonArray
import dev.usbharu.activitystreamsserialization.model.Properties
import dev.usbharu.activitystreamsserialization.model.core.Object
import dev.usbharu.activitystreamsserialization.model.core.ObjectOrLink
import java.net.URI

interface JsonLd {
    var objectFactory: ObjectFactory
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
            val string = jsonObject.obtain(Properties.ID)?.asStringLiteralOrNull() ?: return null
            return URI.create(string.value)
        }
        set(value) {
            jsonObject.setOrRemove(Properties.ID, JsonString.create(value?.toString()))
        }

    fun getAsObjectOrLink(id: String, objectFactory: ObjectFactory = this.objectFactory): List<ObjectOrLink> {
        val jsonNode = jsonObject.obtain(id) ?: return emptyList()
        return jsonNode.asArray().map { objectFactory.create(it) as ObjectOrLink }
    }

    fun setAsObjectOrLink(id: String, `object`: List<ObjectOrLink>) {
        jsonObject.setOrRemove(
            id,
            `object`.map { it.json }.toJsonArray()
        )
    }

    fun getAsObject(id: String, objectFactory: ObjectFactory = this.objectFactory): List<Object> {
        val jsonNode = jsonObject.obtain(id) ?: return emptyList()
        return jsonNode.asArray().map { objectFactory.create(it) as Object }
    }

    fun setAsObject(id: String, `object`: List<Object>) {
        jsonObject.setOrRemove(
            id,
            `object`.map { it.json }.toJsonArray()
        )
    }
}

inline fun <reified T : JsonLd> JsonLd.asTypeOfNull(type: String): T? {
    if (this.type.contains(type).not()) {
        return null
    }
    return this as? T
}