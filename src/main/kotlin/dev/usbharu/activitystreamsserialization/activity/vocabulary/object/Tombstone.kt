package dev.usbharu.activitystreamsserialization.activity.vocabulary.`object`

import dev.usbharu.activitystreamsserialization.activity.Properties
import dev.usbharu.activitystreamsserialization.activity.vocabulary.core.Object
import java.time.OffsetDateTime

interface Tombstone : Object {
    var formerType: List<Object>
        get() = getAsObject(Properties.FORMER_TYPE)
        set(value) = setAsObject(Properties.FORMER_TYPE, value)
    var deleted: OffsetDateTime?
        get() = getOffsetDataTime(Properties.DELETED)
        set(value) = setOffsetDateTime(value, Properties.DELETED)
}