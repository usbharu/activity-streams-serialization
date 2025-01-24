package dev.usbharu.activitystreamsserialization.model.w3idsecurity

import dev.usbharu.activitystreamsserialization.json.JsonNode
import dev.usbharu.activitystreamsserialization.json.JsonString
import dev.usbharu.activitystreamsserialization.model.Properties
import dev.usbharu.activitystreamsserialization.other.JsonLd
import dev.usbharu.activitystreamsserialization.other.ObjectFactory
import java.net.URI

class Key(override var json: JsonNode) : JsonLd {
    var owner: URI?
        get() {
            val string = jsonObject.obtain(Properties.OWNER)?.asStringLiteralOrNull() ?: return null
            return URI.create(string.value)
        }
        set(value) {
            jsonObject.setOrRemove(Properties.OWNER, JsonString.create(value?.toString()))
        }
    var publicKeyPem: String?
        get() {
            val string = jsonObject.obtain(Properties.OWNER)?.asStringLiteralOrNull() ?: return null
            return string.value
        }
        set(value) {
            jsonObject.setOrRemove(Properties.OWNER, JsonString.create(value))
        }
    override var objectFactory: ObjectFactory
        get() = TODO("Not yet implemented")
        set(value) {}
}