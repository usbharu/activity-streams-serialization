package dev.usbharu.activitystreamsserialization.model.activitypub

import dev.usbharu.activitystreamsserialization.json.JsonNode
import dev.usbharu.activitystreamsserialization.json.JsonObject
import dev.usbharu.activitystreamsserialization.json.JsonString
import dev.usbharu.activitystreamsserialization.json.toJsonArray
import dev.usbharu.activitystreamsserialization.model.Properties
import dev.usbharu.activitystreamsserialization.other.JsonLd
import dev.usbharu.activitystreamsserialization.other.ObjectFactory
import java.net.URI

class Endpoint(override var objectFactory: ObjectFactory, override var json: JsonNode) : JsonLd {
    var proxyUrl: List<URI>
        get() = jsonObject.obtain(Properties.PROXY_URL)?.asArray().orEmpty().mapNotNull { it.asObjectOrNull() }
            .mapNotNull { it.obtain(Properties.ID)?.asStringLiteralOrNull() }.map { URI.create(it.value) }
        set(value) = jsonObject.setOrRemove(
            Properties.PROXY_URL,
            value.map { JsonObject(mutableMapOf(Properties.ID to JsonString(it.toString()))) }.toJsonArray()
        )
    var oauthAuthorizationEndpoint: List<URI>
        get() = jsonObject.obtain(Properties.OAUTH_AUTHORIZATION_ENDPOINT)?.asArray().orEmpty()
            .mapNotNull { it.asObjectOrNull() }.mapNotNull { it.obtain(Properties.ID)?.asStringLiteralOrNull() }
            .map { URI.create(it.value) }
        set(value) = jsonObject.setOrRemove(
            Properties.OAUTH_AUTHORIZATION_ENDPOINT,
            value.map { JsonObject(mutableMapOf(Properties.ID to JsonString(it.toString()))) }.toJsonArray()
        )
    var oauthTokenEndpoint: List<URI>
        get() = jsonObject.obtain(Properties.OAUTH_TOKEN_ENDPOINT)?.asArray().orEmpty()
            .mapNotNull { it.asObjectOrNull() }.mapNotNull { it.obtain(Properties.ID)?.asStringLiteralOrNull() }
            .map { URI.create(it.value) }
        set(value) = jsonObject.setOrRemove(
            Properties.OAUTH_TOKEN_ENDPOINT,
            value.map { JsonObject(mutableMapOf(Properties.ID to JsonString(it.toString()))) }.toJsonArray()
        )
    var provideClientKey: List<URI>
        get() = jsonObject.obtain(Properties.PROVIDE_CLIENT_KEY)?.asArray().orEmpty().mapNotNull { it.asObjectOrNull() }
            .mapNotNull { it.obtain(Properties.ID)?.asStringLiteralOrNull() }.map { URI.create(it.value) }
        set(value) = jsonObject.setOrRemove(
            Properties.PROVIDE_CLIENT_KEY,
            value.map { JsonObject(mutableMapOf(Properties.ID to JsonString(it.toString()))) }.toJsonArray()
        )
    var signClientKey: List<URI>
        get() = jsonObject.obtain(Properties.SIGN_CLIENT_KEY)?.asArray().orEmpty().mapNotNull { it.asObjectOrNull() }
            .mapNotNull { it.obtain(Properties.ID)?.asStringLiteralOrNull() }.map { URI.create(it.value) }
        set(value) = jsonObject.setOrRemove(
            Properties.SIGN_CLIENT_KEY,
            value.map { JsonObject(mutableMapOf(Properties.ID to JsonString(it.toString()))) }.toJsonArray()
        )
    var sharedInbox: List<URI>
        get() = jsonObject.obtain(Properties.SHARED_INBOX)?.asArray().orEmpty().mapNotNull { it.asObjectOrNull() }
            .mapNotNull { it.obtain(Properties.ID)?.asStringLiteralOrNull() }.map { URI.create(it.value) }
        set(value) = jsonObject.setOrRemove(
            Properties.SHARED_INBOX,
            value.map { JsonObject(mutableMapOf(Properties.ID to JsonString(it.toString()))) }.toJsonArray()
        )
}