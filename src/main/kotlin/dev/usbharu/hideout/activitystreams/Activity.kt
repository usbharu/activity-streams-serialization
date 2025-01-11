package dev.usbharu.hideout.activitystreams

interface Activity : Object {
    var actor: List<ObjectOrLink>
        get() = getAsObjectOrLink(Properties.ACTOR)
        set(value) = setAsObjectOrLink(Properties.ACTOR, value)
    var `object`: List<ObjectOrLink>
        get() = getAsObjectOrLink(Properties.OBJECT)
        set(value) = setAsObjectOrLink(Properties.OBJECT, value)
}