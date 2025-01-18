package dev.usbharu.hideout.activitystreams.impl

import dev.usbharu.hideout.activitystreams.ObjectFactory
import dev.usbharu.hideout.activitystreams.json.JsonNode

class DefaultActivityStream(override var json: JsonNode, override var objectFactory: ObjectFactory) :
    AbstractActivityStream() {

    override fun toString(): String {
        return "DefaultActivityStream(json=$json)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as DefaultActivityStream

        return json == other.json
    }

    override fun hashCode(): Int {
        return json.hashCode()
    }


}