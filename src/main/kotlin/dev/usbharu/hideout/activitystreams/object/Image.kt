package dev.usbharu.hideout.activitystreams.`object`

import dev.usbharu.hideout.activitystreams.JsonLd
import dev.usbharu.hideout.activitystreams.core.ImageOrLink
import dev.usbharu.hideout.activitystreams.core.Object
import dev.usbharu.hideout.activitystreams.core.ObjectOrLink

interface Image : ImageOrLink, ObjectOrLink, Object, JsonLd {
}