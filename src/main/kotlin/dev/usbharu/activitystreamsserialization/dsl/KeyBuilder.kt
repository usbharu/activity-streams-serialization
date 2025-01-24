package dev.usbharu.activitystreamsserialization.dsl

import dev.usbharu.activitystreamsserialization.json.JsonObject
import dev.usbharu.activitystreamsserialization.model.w3idsecurity.Key
import java.net.URI

class KeysBuilder {
    fun Key(block: KeyBuilder.() -> Unit = {}): Key {
        val keyBuilder = KeyBuilder()
        keyBuilder.block()
        return keyBuilder.key
    }
}

class KeyBuilder() {
    val key = Key(JsonObject(mutableMapOf()))
    fun owner(uri: URI?): KeyBuilder {
        key.owner = uri
        return this
    }

    fun owner(string: String?): KeyBuilder {
        key.owner = URI.create(string ?: return this)
        return this
    }

    fun publicKeyPem(publicKeyPem: String?): KeyBuilder {
        key.publicKeyPem = publicKeyPem
        return this
    }
}