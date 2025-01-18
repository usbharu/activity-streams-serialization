package dev.usbharu.hideout.activitystreams.`object`

import dev.usbharu.hideout.activitystreams.Properties
import dev.usbharu.hideout.activitystreams.core.Object

interface Profile : Object {
    var describes: Object?
        get() = jsonObject.obtain(Properties.DESCRIBES)?.asArray()?.firstOrNull()
            ?.let { objectFactory.create(it) as Object }
        set(value) = jsonObject.setOrRemove(Properties.DESCRIBES, value?.json)


}