package dev.usbharu.hideout.activitystreams.core

import dev.usbharu.hideout.activitystreams.JsonLd
import dev.usbharu.hideout.activitystreams.Properties

interface ActivityOrRelationship : JsonLd {
    var `object`: List<ObjectOrLink>
        get() = getAsObjectOrLink(Properties.OBJECT)
        set(value) = setAsObjectOrLink(Properties.OBJECT, value)
}