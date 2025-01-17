package dev.usbharu.hideout.activitystreams.impl

import dev.usbharu.hideout.activitystreams.JsonLd
import dev.usbharu.hideout.activitystreams.ObjectFactory
import dev.usbharu.hideout.activitystreams.json.JsonNode

object DefaultObjectFactory : ObjectFactory {
    override fun create(jsonNode: JsonNode): JsonLd {
        return DefaultActivityStream(jsonNode, this)
    }

}