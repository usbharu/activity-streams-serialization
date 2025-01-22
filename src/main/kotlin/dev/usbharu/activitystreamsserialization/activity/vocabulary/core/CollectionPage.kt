package dev.usbharu.activitystreamsserialization.activity.vocabulary.core

import dev.usbharu.activitystreamsserialization.activity.Properties

interface CollectionPage : Collection {

    var partOf: CollectionOrLink?
        get() = jsonObject.obtain(Properties.PART_OF)?.asArray()?.firstOrNull()
            ?.let { objectFactory.create(it) } as? CollectionOrLink
        set(value) = jsonObject.setOrRemove(Properties.PART_OF, value?.json)

    var next: CollectionPageOrLink?
        get() {
            val jsonArray = jsonObject.obtain(Properties.NEXT)?.asArray() ?: return null
            return jsonArray.firstOrNull()?.let { objectFactory.create(it) as CollectionPageOrLink }
        }
        set(value) = jsonObject.setOrRemove(Properties.NEXT, value?.json)

    var prev: CollectionPageOrLink?
        get() {
            val jsonArray = jsonObject.obtain(Properties.PREV)?.asArray() ?: return null
            return jsonArray.firstOrNull()?.let { objectFactory.create(it) as CollectionPageOrLink }
        }
        set(value) = jsonObject.setOrRemove(Properties.PREV, value?.json)
}