package dev.usbharu.activitystreamsserialization.model.core

import dev.usbharu.activitystreamsserialization.json.JsonNumber
import dev.usbharu.activitystreamsserialization.model.Properties

interface OrderedCollectionPage : CollectionPage, OrderedCollection {
    var startIndex: UInt?
        get() = jsonObject.obtain(Properties.START_INDEX)?.asNumberLiteralOrNull()?.value?.toUInt()
        set(value) = jsonObject.setOrRemove(Properties.START_INDEX, value?.toDouble()?.let { JsonNumber(it) })
}