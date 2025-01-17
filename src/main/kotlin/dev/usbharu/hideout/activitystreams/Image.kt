package dev.usbharu.hideout.activitystreams

import dev.usbharu.hideout.activitystreams.core.ImageOrLink
import dev.usbharu.hideout.activitystreams.core.Object
import dev.usbharu.hideout.activitystreams.core.ObjectOrLink

interface Image : ImageOrLink, ObjectOrLink, Object, JsonLd {
}