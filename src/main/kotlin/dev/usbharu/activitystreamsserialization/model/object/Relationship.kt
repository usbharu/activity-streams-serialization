package dev.usbharu.activitystreamsserialization.model.`object`

import dev.usbharu.activitystreamsserialization.model.Properties
import dev.usbharu.activitystreamsserialization.model.core.ActivityOrRelationship
import dev.usbharu.activitystreamsserialization.model.core.Object
import dev.usbharu.activitystreamsserialization.model.core.ObjectOrLink

interface Relationship : Object, ActivityOrRelationship {
    var subject: ObjectOrLink?
        get() = jsonObject.obtain(Properties.SUBJECT)?.asArray()?.firstOrNull()
            ?.let { objectFactory.create(it) as ObjectOrLink }
        set(value) = jsonObject.setOrRemove(Properties.SUBJECT, value?.json)
    var relationship: List<Object>
        get() = getAsObject(Properties.RELATIONSHIP)
        set(value) = setAsObject(Properties.RELATIONSHIP, value)
}