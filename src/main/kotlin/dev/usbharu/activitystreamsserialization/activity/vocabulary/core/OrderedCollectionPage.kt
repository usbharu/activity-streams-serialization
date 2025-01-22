package dev.usbharu.activitystreamsserialization.activity.vocabulary.core

import dev.usbharu.activitystreamsserialization.activity.Properties
import dev.usbharu.activitystreamsserialization.json.JsonNumber

interface OrderedCollectionPage : CollectionPage, OrderedCollection {
    var startIndex: UInt?
        get() = jsonObject.obtain(Properties.START_INDEX)?.asNumberLiteralOrNull()?.value?.toUInt()
        set(value) = jsonObject.setOrRemove(Properties.START_INDEX, value?.toDouble()?.let { JsonNumber(it) })
}