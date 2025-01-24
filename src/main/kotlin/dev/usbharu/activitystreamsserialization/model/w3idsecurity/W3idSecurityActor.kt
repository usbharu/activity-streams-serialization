package dev.usbharu.activitystreamsserialization.model.w3idsecurity

import dev.usbharu.activitystreamsserialization.json.toJsonArray
import dev.usbharu.activitystreamsserialization.model.Properties
import dev.usbharu.activitystreamsserialization.other.JsonLd

interface W3idSecurityActor : JsonLd {
    var publicKey: List<Key>
        get() {
            return jsonObject.obtain(Properties.PUBLIC_KEY)?.asArray().orEmpty().map {
                Key(it)
            }
        }
        set(value) {
            return jsonObject.setOrRemove(Properties.PUBLIC_KEY, value.map { it.json }.toJsonArray())
        }
}