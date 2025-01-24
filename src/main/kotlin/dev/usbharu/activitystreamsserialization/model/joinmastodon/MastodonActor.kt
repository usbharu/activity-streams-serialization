package dev.usbharu.activitystreamsserialization.model.joinmastodon

import dev.usbharu.activitystreamsserialization.json.JsonArray
import dev.usbharu.activitystreamsserialization.json.JsonBoolean
import dev.usbharu.activitystreamsserialization.json.JsonObject
import dev.usbharu.activitystreamsserialization.model.Properties
import dev.usbharu.activitystreamsserialization.other.JsonLd

interface MastodonActor : JsonLd {
    var discoverable: Boolean?
        get() {
            return jsonObject.obtain(Properties.DISCOVERABLE)?.asArray().orEmpty().firstOrNull()
                ?.asObjectOrNull()?.get(Properties.VALUE)?.asBooleanLiteralOrNull()?.value
        }
        set(value) {
            jsonObject.setOrRemove(
                Properties.DISCOVERABLE, JsonArray(
                    mutableListOf(
                        JsonObject(
                            mutableMapOf(Properties.VALUE to JsonBoolean(value ?: return))
                        )
                    )
                )
            )
        }
    var featured: Boolean?
        get() {
            return jsonObject.obtain(Properties.FEATURED)?.asArray().orEmpty().firstOrNull()
                ?.asObjectOrNull()?.get(Properties.VALUE)?.asBooleanLiteralOrNull()?.value
        }
        set(value) {
            jsonObject.setOrRemove(
                Properties.FEATURED, JsonArray(
                    mutableListOf(
                        JsonObject(
                            mutableMapOf(Properties.VALUE to JsonBoolean(value ?: return))
                        )
                    )
                )
            )
        }

}