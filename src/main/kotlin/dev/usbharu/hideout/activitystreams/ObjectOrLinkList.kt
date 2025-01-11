package dev.usbharu.hideout.activitystreams

import dev.usbharu.hideout.activitystreams.json.JsonObject
import dev.usbharu.hideout.activitystreams.json.toJsonArray
import kotlin.reflect.KProperty

class ObjectOrLinkList(private val jsonObject: JsonObject, private val key: String) {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): List<ObjectOrLink> {
        val jsonNode = jsonObject.obtain(key) ?: return emptyList()
        return jsonNode.asArray().map { ObjectFactory.factory(it) as ObjectOrLink }
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: List<ObjectOrLink>) {
        jsonObject.setOrRemove(
            key,
            value.map { ObjectFactory.toJsonNode(it) }.toJsonArray()
        )
    }
}