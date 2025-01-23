package dev.usbharu.activitystreamsserialization.model.core

import dev.usbharu.activitystreamsserialization.json.JsonNumber
import dev.usbharu.activitystreamsserialization.json.JsonString
import dev.usbharu.activitystreamsserialization.json.toJsonArray
import dev.usbharu.activitystreamsserialization.model.Properties
import dev.usbharu.activitystreamsserialization.model.Type
import dev.usbharu.activitystreamsserialization.other.JsonLd
import dev.usbharu.activitystreamsserialization.other.Uri

interface Link : ObjectOrLinkOrDateTimeOrBoolean, ObjectOrLink, UriOrLink, ImageOrLink, CollectionPageOrLink,
    CollectionOrLink, JsonLd {
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