package dev.usbharu.activitystreamsserialization.dsl

import dev.usbharu.activitystreamsserialization.other.JsonLd
import java.net.URI

abstract class AbstractJsonLdBuilder {

    abstract val Object: JsonLd

    fun id(uri: URI?): AbstractJsonLdBuilder {
        Object.id = uri
        return this
    }

    fun id(string: String?): AbstractJsonLdBuilder {
        id(URI.create(string ?: return this))
        return this
    }
}