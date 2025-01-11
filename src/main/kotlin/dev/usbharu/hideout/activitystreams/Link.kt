package dev.usbharu.hideout.activitystreams

import dev.usbharu.hideout.activitystreams.json.JsonNumber
import dev.usbharu.hideout.activitystreams.json.JsonString
import dev.usbharu.hideout.activitystreams.json.toJsonArray

interface Link : ObjectOrLink, UriOrLink, ImageOrLink, CollectionPageOrLink, CollectionOrLink, JsonLd {
    var href: Uri?
        get() = jsonObject.obtain(Properties.HREF)?.let { Uri(it) }
        set(value) = jsonObject.setOrRemove(Properties.HREF, value?.json)

    var hreflang: String?
        get() = jsonObject.obtain(Properties.HREFLANG)?.asStringLiteralOrNull()?.value
        set(value) = jsonObject.setOrRemove(Properties.HREFLANG, value?.let { JsonString(it) })

    var rel: List<String>
        get() = jsonObject.obtain(Properties.REL)?.asArray().orEmpty().mapNotNull { it.asStringLiteralOrNull()?.value }
        set(value) = jsonObject.setOrRemove(Properties.REL, value.map { JsonString(it) }.toJsonArray())

    var height: UInt?
        get() = jsonObject.obtain(Properties.HEIGHT)?.asNumberLiteralOrNull()?.value?.toUInt()
        set(value) = jsonObject.setOrRemove(Properties.HEIGHT, value?.toDouble()?.let { JsonNumber(it) })

    var width: UInt?
        get() = jsonObject.obtain(Properties.WIDTH)?.asNumberLiteralOrNull()?.value?.toUInt()
        set(value) = jsonObject.setOrRemove(Properties.WIDTH, value?.toDouble()?.let { JsonNumber(it) })

    override fun isLink(): Boolean {
        return type.contains(Type.LINK)
    }
}