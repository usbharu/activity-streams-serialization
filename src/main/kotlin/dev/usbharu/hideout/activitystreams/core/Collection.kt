package dev.usbharu.hideout.activitystreams.core

import dev.usbharu.hideout.activitystreams.ObjectFactory
import dev.usbharu.hideout.activitystreams.Properties
import dev.usbharu.hideout.activitystreams.impl.DefaultObjectFactory
import dev.usbharu.hideout.activitystreams.json.JsonNumber
import dev.usbharu.hideout.activitystreams.json.JsonObject

interface Collection : Object {
    var totalItems: UInt?
        get() {
            val jsonNode = jsonObject.obtain(Properties.TOTAL_ITEMS)?.asArray()?.firstOrNull() ?: return null
            require(jsonNode.isObject)
            jsonNode as JsonObject
            return jsonNode[Properties.VALUE]?.asNumberLiteralOrNull()?.value?.toUInt()
        }
        set(value) = jsonObject.setOrRemove(Properties.TOTAL_ITEMS, value?.toDouble()?.let { JsonNumber(it) })

    var current: CollectionPageOrLink?
        get() {
            val jsonArray = jsonObject.obtain(Properties.CURRENT)?.asArray() ?: return null
            return jsonArray.firstOrNull()?.let { DefaultObjectFactory.create(it) as CollectionPageOrLink }
        }
        set(value) = jsonObject.setOrRemove(Properties.CURRENT, value?.json)

    var first: CollectionPageOrLink?
        get() {
            val jsonArray = jsonObject.obtain(Properties.FIRST)?.asArray() ?: return null
            return jsonArray.firstOrNull()?.let { DefaultObjectFactory.create(it) as CollectionPageOrLink }
        }
        set(value) = jsonObject.setOrRemove(Properties.FIRST, value?.json)

    var last: CollectionPageOrLink?
        get() {
            val jsonArray = jsonObject.obtain(Properties.LAST)?.asArray() ?: return null
            return jsonArray.firstOrNull()?.let { DefaultObjectFactory.create(it) as CollectionPageOrLink }
        }
        set(value) = jsonObject.setOrRemove(Properties.LAST, value?.json)

    var items: List<ObjectOrLink>
        get() = items()
        set(value) = setAsObjectOrLink(Properties.ITEMS, value)
}

var Collection?.items: List<ObjectOrLink>
    get() = this.items()
    set(value) {
        this?.items = value
    }

fun Collection?.items(objectFactory: ObjectFactory? = this?.objectFactory): List<ObjectOrLink> {
    if (this == null) {
        return emptyList()
    }
    requireNotNull(objectFactory)
    return getAsObjectOrLink(Properties.ITEMS, objectFactory)
}