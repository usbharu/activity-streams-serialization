package dev.usbharu.hideout.activitystreams.impl

import dev.usbharu.hideout.activitystreams.ObjectFactory
import dev.usbharu.hideout.activitystreams.json.JsonNode

class DefaultActivityStream(override var json: JsonNode, override var objectFactory: ObjectFactory) :
    AbstractActivityStream() {

    override fun toString(): String {
        return "DefaultActivityStream(json=$json)"
    }
}