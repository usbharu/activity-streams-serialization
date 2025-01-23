package dev.usbharu.activitystreamsserialization.model.`object`

import dev.usbharu.activitystreamsserialization.model.Properties
import dev.usbharu.activitystreamsserialization.model.core.Object
import java.time.OffsetDateTime

interface Tombstone : Object {
    var formerType: List<Object>
        get() = getAsObject(Properties.FORMER_TYPE)
        set(value) = setAsObject(Properties.FORMER_TYPE, value)
    var deleted: OffsetDateTime?
        get() = getOffsetDataTime(Properties.DELETED)
        set(value) = setOffsetDateTime(value, Properties.DELETED)
}