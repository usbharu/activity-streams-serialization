package dev.usbharu.activitystreamsserialization.activity.vocabulary.core

import dev.usbharu.activitystreamsserialization.activity.JsonLd
import dev.usbharu.activitystreamsserialization.activity.Properties

interface ActivityOrRelationship : JsonLd {
    var `object`: List<ObjectOrLink>
        get() = getAsObjectOrLink(Properties.OBJECT)
        set(value) = setAsObjectOrLink(Properties.OBJECT, value)
}