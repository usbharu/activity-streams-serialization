package dev.usbharu.hideout.activitystreams

sealed interface InternalActivity : Object {
    var actor: List<ObjectOrLink>
        get() = getAsObjectOrLink(Properties.ACTOR)
        set(value) = setAsObjectOrLink(Properties.ACTOR, value)

    var target: List<ObjectOrLink>
        get() = getAsObjectOrLink(Properties.TARGET)
        set(value) = setAsObjectOrLink(Properties.TARGET, value)

    var result: List<ObjectOrLink>
        get() = getAsObjectOrLink(Properties.RESULT)
        set(value) = setAsObjectOrLink(Properties.RESULT, value)

    var origin: List<ObjectOrLink>
        get() = getAsObjectOrLink(Properties.ORIGIN)
        set(value) = setAsObjectOrLink(Properties.ORIGIN, value)

    var instrument: List<ObjectOrLink>
        get() = getAsObjectOrLink(Properties.INSTRUMENT)
        set(value) = setAsObjectOrLink(Properties.INSTRUMENT, value)
}

interface Activity : InternalActivity {
    var `object`: List<ObjectOrLink>
        get() = getAsObjectOrLink(Properties.OBJECT)
        set(value) = setAsObjectOrLink(Properties.OBJECT, value)
}

interface IntransitiveActivity : InternalActivity