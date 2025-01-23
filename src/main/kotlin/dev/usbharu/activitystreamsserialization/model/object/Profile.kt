package dev.usbharu.activitystreamsserialization.model.`object`


import dev.usbharu.activitystreamsserialization.model.Properties
import dev.usbharu.activitystreamsserialization.model.core.Object

interface Profile : Object {
    var describes: Object?
        get() = jsonObject.obtain(Properties.DESCRIBES)?.asArray()?.firstOrNull()
            ?.let { objectFactory.create(it) as Object }
        set(value) = jsonObject.setOrRemove(Properties.DESCRIBES, value?.json)


}