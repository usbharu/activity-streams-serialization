package dev.usbharu.activitystreamsserialization.model.`object`

import dev.usbharu.activitystreamsserialization.model.core.ImageOrLink
import dev.usbharu.activitystreamsserialization.model.core.Object
import dev.usbharu.activitystreamsserialization.model.core.ObjectOrLink
import dev.usbharu.activitystreamsserialization.other.JsonLd

interface Image : ImageOrLink, ObjectOrLink, Object, JsonLd {
}