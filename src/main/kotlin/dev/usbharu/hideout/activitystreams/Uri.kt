package dev.usbharu.hideout.activitystreams

import dev.usbharu.hideout.activitystreams.json.JsonNode
import java.net.URI

data class Uri(override var json: JsonNode) : UriOrLink {
    fun asUri(): URI? {
        return URI.create(jsonObject[Properties.ID]?.asStringLiteralOrNull()?.value ?: return null)
    }
}