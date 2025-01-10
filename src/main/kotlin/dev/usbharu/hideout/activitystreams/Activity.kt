package dev.usbharu.hideout.activitystreams

import dev.usbharu.hideout.activitystreams.json.toJsonArray

interface Activity : Object {
    var actor: List<ObjectOrLink>
        get() = getAsObjectOrLink("https://www.w3.org/ns/activitystreams#actor")
        set(value) = setAsObjectOrLink("https://www.w3.org/ns/activitystreams#actor", value)
    var `object`: List<ObjectOrLink>
        get() = getAsObjectOrLink("https://www.w3.org/ns/activitystreams#object")
        set(value) = setAsObjectOrLink("https://www.w3.org/ns/activitystreams#object", value)
}