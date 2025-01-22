package dev.usbharu.activitystreamsserialization.activity.vocabulary.`object`

import dev.usbharu.activitystreamsserialization.activity.vocabulary.core.ImageOrLink
import dev.usbharu.activitystreamsserialization.activity.vocabulary.core.Object
import dev.usbharu.activitystreamsserialization.activity.vocabulary.core.ObjectOrLink
import dev.usbharu.activitystreamsserialization.other.JsonLd

interface Image : ImageOrLink, ObjectOrLink, Object, JsonLd {
}