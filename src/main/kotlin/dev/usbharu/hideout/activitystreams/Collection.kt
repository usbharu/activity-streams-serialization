package dev.usbharu.hideout.activitystreams

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
            return jsonArray.firstOrNull()?.let { ObjectFactory.factory(it) as CollectionPageOrLink }
        }
        set(value) = jsonObject.setOrRemove(Properties.CURRENT, value?.json)

    var first: CollectionPageOrLink?
        get() {
            val jsonArray = jsonObject.obtain(Properties.FIRST)?.asArray() ?: return null
            return jsonArray.firstOrNull()?.let { ObjectFactory.factory(it) as CollectionPageOrLink }
        }
        set(value) = jsonObject.setOrRemove(Properties.FIRST, value?.json)

    var last: CollectionPageOrLink?
        get() {
            val jsonArray = jsonObject.obtain(Properties.LAST)?.asArray() ?: return null
            return jsonArray.firstOrNull()?.let { ObjectFactory.factory(it) as CollectionPageOrLink }
        }
        set(value) = jsonObject.setOrRemove(Properties.LAST, value?.json)

    var items: List<ObjectOrLink>
        get() = getAsObjectOrLink(Properties.ITEMS)
        set(value) = setAsObjectOrLink(Properties.ITEMS, value)
}