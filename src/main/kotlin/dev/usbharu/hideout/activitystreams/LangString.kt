package dev.usbharu.hideout.activitystreams

import dev.usbharu.hideout.activitystreams.json.JsonObject
import dev.usbharu.hideout.activitystreams.json.JsonString

data class LangString(val language: String? = null, val value: String) {
    fun toJsonObject(): JsonObject {
        return JsonObject(
            if (language != null) {
                mutableMapOf(
                    "@language" to JsonString(language),
                    "@value" to JsonString(value)
                )
            } else {
                mutableMapOf(
                    "@value" to JsonString(value)
                )
            }
        )
    }
}
