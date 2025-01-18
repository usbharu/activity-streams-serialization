package dev.usbharu.hideout.activitystreams.other

import dev.usbharu.hideout.activitystreams.ObjectFactory
import dev.usbharu.hideout.activitystreams.Properties
import dev.usbharu.hideout.activitystreams.core.UriOrLink
import dev.usbharu.hideout.activitystreams.json.JsonNode
import dev.usbharu.hideout.activitystreams.json.JsonObject
import dev.usbharu.hideout.activitystreams.json.JsonString
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