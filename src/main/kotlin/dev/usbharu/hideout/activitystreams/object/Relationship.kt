package dev.usbharu.hideout.activitystreams.`object`

import dev.usbharu.hideout.activitystreams.Properties
import dev.usbharu.hideout.activitystreams.core.ActivityOrRelationship
import dev.usbharu.hideout.activitystreams.core.Object
import dev.usbharu.hideout.activitystreams.core.ObjectOrLink

interface Relationship : Object, ActivityOrRelationship {
    var subject: ObjectOrLink?
        get() = jsonObject.obtain(Properties.SUBJECT)?.asArray()?.firstOrNull()
            ?.let { objectFactory.create(it) as ObjectOrLink }
        set(value) = jsonObject.setOrRemove(Properties.SUBJECT, value?.json)
    var relationship: List<Object>
        get() = getAsObject(Properties.RELATIONSHIP)
        set(value) = setAsObject(Properties.RELATIONSHIP, value)
}