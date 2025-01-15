package dev.usbharu.hideout.activitystreams

import dev.usbharu.hideout.activitystreams.impl.DefaultActivityStream
import dev.usbharu.hideout.activitystreams.json.JsonNode

object DefaultObjectFactory : ObjectFactory {
    override fun create(jsonNode: JsonNode): JsonLd {
        return DefaultActivityStream(jsonNode, this)
    }

}