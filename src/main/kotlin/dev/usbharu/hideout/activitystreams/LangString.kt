package dev.usbharu.hideout.activitystreams

import dev.usbharu.hideout.activitystreams.json.JsonObject
import dev.usbharu.hideout.activitystreams.json.JsonString

data class LangString(val language: String? = null, val value: String) {
    fun toJsonObject(): JsonObject {
        return JsonObject(
            if (language != null) {
                mutableMapOf(
                    Properties.LANGUAGE to JsonString(language),
                    Properties.VALUE to JsonString(value)
                )
            } else {
                mutableMapOf(
                    Properties.VALUE to JsonString(value)
                )
            }
        )
    }
}

fun List<LangString>?.getAsMap(): Map<String, String> {
    return orEmpty().associate { (it.language ?: "default") to it.value }
}