package dev.usbharu.hideout.activitystreams

import dev.usbharu.hideout.activitystreams.json.JsonString

interface ObjectOrLink : JsonLd {
    fun isObject(): Boolean
    fun isLink(): Boolean

    var attributedTo: List<ObjectOrLink>
        get() = getAsObjectOrLink(Properties.ATTRIBUTED_TO)
        set(value) = setAsObjectOrLink(Properties.ATTRIBUTED_TO, value)

    var preview: List<ObjectOrLink>
        get() = getAsObjectOrLink(Properties.PREVIEW)
        set(value) = setAsObjectOrLink(Properties.PREVIEW, value)

    var mediaType: String?
        get() = jsonObject.obtain(Properties.MEDIA_TYPE)?.asStringLiteralOrNull()?.value
        set(value) = jsonObject.setOrRemove(Properties.MEDIA_TYPE, value?.let { JsonString(it) })
}

fun List<ObjectOrLink>.objects(): List<Object> {
    return this.filter { it.isObject() }.map { it as Object }
}

fun List<ObjectOrLink>.links(): List<ObjectOrLink> { //todo linkに変える
    return this.filter { it.isLink() }
}