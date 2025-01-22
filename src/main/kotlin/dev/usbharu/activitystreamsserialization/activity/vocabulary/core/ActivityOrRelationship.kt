package dev.usbharu.activitystreamsserialization.activity.vocabulary.core

import dev.usbharu.activitystreamsserialization.activity.Properties
import dev.usbharu.activitystreamsserialization.other.JsonLd

interface ActivityOrRelationship : JsonLd {
    var `object`: List<ObjectOrLink>
        get() = getAsObjectOrLink(Properties.OBJECT)
        set(value) = setAsObjectOrLink(Properties.OBJECT, value)
}