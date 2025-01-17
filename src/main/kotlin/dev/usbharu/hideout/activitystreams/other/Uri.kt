package dev.usbharu.hideout.activitystreams.other

import dev.usbharu.hideout.activitystreams.ObjectFactory
import dev.usbharu.hideout.activitystreams.Properties
import dev.usbharu.hideout.activitystreams.core.UriOrLink
import dev.usbharu.hideout.activitystreams.json.JsonNode
import java.net.URI

data class Uri(override var json: JsonNode) : UriOrLink {
    fun asUri(): URI? {
        return URI.create(jsonObject[Properties.ID]?.asStringLiteralOrNull()?.value ?: return null)
    }

    override var objectFactory: ObjectFactory
        get() = TODO("Not yet implemented")
        set(value) {}
}