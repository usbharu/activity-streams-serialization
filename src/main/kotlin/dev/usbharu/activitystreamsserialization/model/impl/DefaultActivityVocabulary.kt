package dev.usbharu.activitystreamsserialization.model.impl

import dev.usbharu.activitystreamsserialization.json.JsonNode
import dev.usbharu.activitystreamsserialization.other.ObjectFactory

open class DefaultActivityVocabulary(override var json: JsonNode, override var objectFactory: ObjectFactory) :
    AbstractActivityVocabulary() {

    override fun toString(): String {
        return "DefaultActivityStream(json=$json)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as DefaultActivityVocabulary

        return json == other.json
    }

    override fun hashCode(): Int {
        return json.hashCode()
    }


}