package dev.usbharu.hideout.activitystreams.core

import dev.usbharu.hideout.activitystreams.Properties
import dev.usbharu.hideout.activitystreams.json.JsonNumber

interface OrderedCollectionPage : CollectionPage, OrderedCollection {
    var startIndex: UInt?
        get() = jsonObject.obtain(Properties.START_INDEX)?.asNumberLiteralOrNull()?.value?.toUInt()
        set(value) = jsonObject.setOrRemove(Properties.START_INDEX, value?.toDouble()?.let { JsonNumber(it) })
}