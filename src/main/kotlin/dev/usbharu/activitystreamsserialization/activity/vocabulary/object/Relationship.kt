package dev.usbharu.activitystreamsserialization.activity.vocabulary.`object`

import dev.usbharu.activitystreamsserialization.activity.Properties
import dev.usbharu.activitystreamsserialization.activity.vocabulary.core.ActivityOrRelationship
import dev.usbharu.activitystreamsserialization.activity.vocabulary.core.Object
import dev.usbharu.activitystreamsserialization.activity.vocabulary.core.ObjectOrLink

interface Relationship : Object, ActivityOrRelationship {
    var subject: ObjectOrLink?
        get() = jsonObject.obtain(Properties.SUBJECT)?.asArray()?.firstOrNull()
            ?.let { objectFactory.create(it) as ObjectOrLink }
        set(value) = jsonObject.setOrRemove(Properties.SUBJECT, value?.json)
    var relationship: List<Object>
        get() = getAsObject(Properties.RELATIONSHIP)
        set(value) = setAsObject(Properties.RELATIONSHIP, value)
}