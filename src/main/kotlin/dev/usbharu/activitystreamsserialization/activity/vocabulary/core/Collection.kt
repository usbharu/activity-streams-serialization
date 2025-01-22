package dev.usbharu.activitystreamsserialization.activity.vocabulary.core

import dev.usbharu.activitystreamsserialization.activity.Properties
import dev.usbharu.activitystreamsserialization.activity.vocabulary.impl.DefaultObjectFactory
import dev.usbharu.activitystreamsserialization.json.JsonNumber
import dev.usbharu.activitystreamsserialization.json.JsonObject
import dev.usbharu.activitystreamsserialization.other.ObjectFactory

interface Collection : dev.usbharu.activitystreamsserialization.activity.vocabulary.core.Object {
    var totalItems: UInt?
        get() {
            val jsonNode = jsonObject.obtain(Properties.TOTAL_ITEMS)?.asArray()?.firstOrNull() ?: return null
            require(jsonNode.isObject)
            jsonNode as JsonObject
            return jsonNode[Properties.VALUE]?.asNumberLiteralOrNull()?.value?.toUInt()
        }
        set(value) = jsonObject.setOrRemove(Properties.TOTAL_ITEMS, value?.toDouble()?.let { JsonNumber(it) })

    var current: dev.usbharu.activitystreamsserialization.activity.vocabulary.core.CollectionPageOrLink?
        get() {
            val jsonArray = jsonObject.obtain(Properties.CURRENT)?.asArray() ?: return null
            return jsonArray.firstOrNull()
                ?.let { DefaultObjectFactory.create(it) as dev.usbharu.activitystreamsserialization.activity.vocabulary.core.CollectionPageOrLink }
        }
        set(value) = jsonObject.setOrRemove(Properties.CURRENT, value?.json)

    var first: dev.usbharu.activitystreamsserialization.activity.vocabulary.core.CollectionPageOrLink?
        get() {
            val jsonArray = jsonObject.obtain(Properties.FIRST)?.asArray() ?: return null
            return jsonArray.firstOrNull()
                ?.let { DefaultObjectFactory.create(it) as dev.usbharu.activitystreamsserialization.activity.vocabulary.core.CollectionPageOrLink }
        }
        set(value) = jsonObject.setOrRemove(Properties.FIRST, value?.json)

    var last: dev.usbharu.activitystreamsserialization.activity.vocabulary.core.CollectionPageOrLink?
        get() {
            val jsonArray = jsonObject.obtain(Properties.LAST)?.asArray() ?: return null
            return jsonArray.firstOrNull()
                ?.let { DefaultObjectFactory.create(it) as dev.usbharu.activitystreamsserialization.activity.vocabulary.core.CollectionPageOrLink }
        }
        set(value) = jsonObject.setOrRemove(Properties.LAST, value?.json)

    var items: List<dev.usbharu.activitystreamsserialization.activity.vocabulary.core.ObjectOrLink>
        get() = items()
        set(value) = setAsObjectOrLink(Properties.ITEMS, value)
}

var dev.usbharu.activitystreamsserialization.activity.vocabulary.core.Collection?.items: List<dev.usbharu.activitystreamsserialization.activity.vocabulary.core.ObjectOrLink>
    get() = this.items()
    set(value) {
        this?.items = value
    }

fun dev.usbharu.activitystreamsserialization.activity.vocabulary.core.Collection?.items(objectFactory: ObjectFactory? = this?.objectFactory): List<dev.usbharu.activitystreamsserialization.activity.vocabulary.core.ObjectOrLink> {
    if (this == null) {
        return emptyList()
    }
    requireNotNull(objectFactory)
    return getAsObjectOrLink(Properties.ITEMS, objectFactory)
}