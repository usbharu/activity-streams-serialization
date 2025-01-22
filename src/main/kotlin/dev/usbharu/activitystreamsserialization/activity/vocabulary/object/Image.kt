package dev.usbharu.activitystreamsserialization.activity.vocabulary.`object`

import dev.usbharu.activitystreamsserialization.activity.JsonLd
import dev.usbharu.activitystreamsserialization.activity.vocabulary.core.ImageOrLink
import dev.usbharu.activitystreamsserialization.activity.vocabulary.core.Object
import dev.usbharu.activitystreamsserialization.activity.vocabulary.core.ObjectOrLink

interface Image : ImageOrLink, ObjectOrLink, Object, JsonLd {
}