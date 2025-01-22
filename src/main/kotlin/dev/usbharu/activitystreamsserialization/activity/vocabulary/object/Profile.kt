package dev.usbharu.activitystreamsserialization.activity.vocabulary.`object`


import dev.usbharu.activitystreamsserialization.activity.Properties
import dev.usbharu.activitystreamsserialization.activity.vocabulary.core.Object

interface Profile : Object {
    var describes: Object?
        get() = jsonObject.obtain(Properties.DESCRIBES)?.asArray()?.firstOrNull()
            ?.let { objectFactory.create(it) as Object }
        set(value) = jsonObject.setOrRemove(Properties.DESCRIBES, value?.json)


}