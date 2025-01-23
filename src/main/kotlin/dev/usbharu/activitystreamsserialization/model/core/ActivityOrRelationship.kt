package dev.usbharu.activitystreamsserialization.model.core

import dev.usbharu.activitystreamsserialization.model.Properties
import dev.usbharu.activitystreamsserialization.other.JsonLd

interface ActivityOrRelationship : JsonLd {
    var `object`: List<ObjectOrLink>
        get() = getAsObjectOrLink(Properties.OBJECT)
        set(value) = setAsObjectOrLink(Properties.OBJECT, value)
}