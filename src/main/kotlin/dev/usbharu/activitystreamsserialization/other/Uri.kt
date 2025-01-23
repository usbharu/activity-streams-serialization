package dev.usbharu.activitystreamsserialization.other

import dev.usbharu.activitystreamsserialization.json.JsonNode
import dev.usbharu.activitystreamsserialization.json.JsonObject
import dev.usbharu.activitystreamsserialization.json.JsonString
import dev.usbharu.activitystreamsserialization.model.Properties
import dev.usbharu.activitystreamsserialization.model.core.UriOrLink
import java.net.URI

data class Uri(override var json: JsonNode) : UriOrLink, UriOrUnits {
    fun asUri(): URI? {
        return URI.create(jsonObject[Properties.ID]?.asStringLiteralOrNull()?.value ?: return null)
    }

    companion object {
        fun fromURI(uri: URI): Uri {
            return Uri(JsonObject(mutableMapOf(Properties.ID to JsonString(uri.toString()))))
        }
    }

    override var objectFactory: ObjectFactory
        get() = TODO("Not yet implemented")
        set(value) {}
}