package dev.usbharu.activitystreamsserialization.activity.pub

import dev.usbharu.activitystreamsserialization.activity.Properties
import dev.usbharu.activitystreamsserialization.activity.vocabulary.core.Object
import dev.usbharu.activitystreamsserialization.json.JsonObject
import dev.usbharu.activitystreamsserialization.json.JsonString
import dev.usbharu.activitystreamsserialization.json.toJsonArray
import dev.usbharu.activitystreamsserialization.other.JsonLd
import dev.usbharu.activitystreamsserialization.other.LangString
import java.net.URI

interface ActivityPubActor : Object, JsonLd {
    var inbox: List<URI>
        get() = jsonObject.obtain(Properties.INBOX)?.asArray().orEmpty().mapNotNull { it.asObjectOrNull() }
            .mapNotNull { it.obtain(Properties.ID)?.asStringLiteralOrNull() }.map { URI.create(it.value) }
        set(value) = jsonObject.setOrRemove(
            Properties.INBOX,
            value.map { JsonObject(mutableMapOf(Properties.ID to JsonString(it.toString()))) }.toJsonArray()
        )
    var outbox: List<URI>
        get() = jsonObject.obtain(Properties.OUTBOX)?.asArray().orEmpty().mapNotNull { it.asObjectOrNull() }
            .mapNotNull { it.obtain(Properties.ID)?.asStringLiteralOrNull() }.map { URI.create(it.value) }
        set(value) = jsonObject.setOrRemove(
            Properties.OUTBOX,
            value.map { JsonObject(mutableMapOf(Properties.ID to JsonString(it.toString()))) }.toJsonArray()
        )
    var following: List<URI>
        get() = jsonObject.obtain(Properties.FOLLOWING)?.asArray().orEmpty().mapNotNull { it.asObjectOrNull() }
            .mapNotNull { it.obtain(Properties.ID)?.asStringLiteralOrNull() }.map { URI.create(it.value) }
        set(value) = jsonObject.setOrRemove(
            Properties.FOLLOWING,
            value.map { JsonObject(mutableMapOf(Properties.ID to JsonString(it.toString()))) }.toJsonArray()
        )
    var followers: List<URI>
        get() = jsonObject.obtain(Properties.FOLLOWERS)?.asArray().orEmpty().mapNotNull { it.asObjectOrNull() }
            .mapNotNull { it.obtain(Properties.ID)?.asStringLiteralOrNull() }.map { URI.create(it.value) }
        set(value) = jsonObject.setOrRemove(
            Properties.FOLLOWERS,
            value.map { JsonObject(mutableMapOf(Properties.ID to JsonString(it.toString()))) }.toJsonArray()
        )
    var liked: List<URI>
        get() = jsonObject.obtain(Properties.LIKED)?.asArray().orEmpty().mapNotNull { it.asObjectOrNull() }
            .mapNotNull { it.obtain(Properties.ID)?.asStringLiteralOrNull() }.map { URI.create(it.value) }
        set(value) = jsonObject.setOrRemove(
            Properties.LIKED,
            value.map { JsonObject(mutableMapOf(Properties.ID to JsonString(it.toString()))) }.toJsonArray()
        )
    var streams: List<URI>
        get() = jsonObject.obtain(Properties.STREAMS)?.asArray().orEmpty().mapNotNull { it.asObjectOrNull() }
            .mapNotNull { it.obtain(Properties.ID)?.asStringLiteralOrNull() }.map { URI.create(it.value) }
        set(value) = jsonObject.setOrRemove(
            Properties.STREAMS,
            value.map { JsonObject(mutableMapOf(Properties.ID to JsonString(it.toString()))) }.toJsonArray()
        )
    var preferredUsername: List<LangString>
        get() {
            val jsonNode = jsonObject.obtain(Properties.PREFERRED_USERNAME) ?: return emptyList()

            return jsonNode.asArray().map {
                require(it.isObject)
                it as JsonObject
                LangString(
                    it[Properties.LANGUAGE]?.asStringLiteralOrNull()?.value,
                    it[Properties.VALUE]!!.asStringLiteralOrNull()?.value.toString()
                )
            }
        }
        set(value) {
            jsonObject.setOrRemove(
                Properties.PREFERRED_USERNAME, value.map { it.toJsonObject() }.toJsonArray()
            )
        }
    var endpoints: List<Endpoint>
        get() {
            val jsonNode = jsonObject.obtain(Properties.ENDPOINTS) ?: return emptyList()
            return jsonNode.asArray().map { Endpoint(objectFactory, json) }
        }
        set(value) {
            jsonObject.setOrRemove(
                Properties.ENDPOINTS, value.map { it.json }.toJsonArray()
            )
        }
}