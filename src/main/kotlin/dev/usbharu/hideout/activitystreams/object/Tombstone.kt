package dev.usbharu.hideout.activitystreams.`object`

import dev.usbharu.hideout.activitystreams.Properties
import dev.usbharu.hideout.activitystreams.core.Object
import java.time.OffsetDateTime

interface Tombstone : Object {
    var formerType: List<Object>
        get() = getAsObject(Properties.FORMER_TYPE)
        set(value) = setAsObject(Properties.FORMER_TYPE, value)
    var deleted: OffsetDateTime?
        get() = getOffsetDataTime(Properties.DELETED)
        set(value) = setOffsetDateTime(value, Properties.DELETED)
}