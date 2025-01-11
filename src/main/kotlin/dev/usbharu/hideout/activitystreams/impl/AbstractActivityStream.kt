package dev.usbharu.hideout.activitystreams.impl

import dev.usbharu.hideout.activitystreams.Activity
import dev.usbharu.hideout.activitystreams.JsonLd
import dev.usbharu.hideout.activitystreams.Object
import dev.usbharu.hideout.activitystreams.ObjectOrLink

abstract class AbstractActivityStream : Activity, JsonLd, Object, ObjectOrLink {
    override fun isObject(): Boolean {
        return true //todo
    }

    override fun isLink(): Boolean {
        return type.contains("https://www.w3.org/ns/activitystreams#Link")
    }
}