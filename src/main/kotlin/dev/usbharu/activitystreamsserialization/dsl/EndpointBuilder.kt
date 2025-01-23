package dev.usbharu.activitystreamsserialization.dsl

import dev.usbharu.activitystreamsserialization.json.JsonObject
import dev.usbharu.activitystreamsserialization.model.activitypub.Endpoint
import dev.usbharu.activitystreamsserialization.other.ObjectFactory
import java.net.URI

class EndpointsBuilder(var objectFactory: ObjectFactory) {
    fun Endpoint(block: EndpointBuilder.() -> Unit = {}): Endpoint {
        val endpointBuilder = EndpointBuilder(objectFactory)
        endpointBuilder.block()
        return endpointBuilder.endpoint
    }
}

class EndpointBuilder(var objectFactory: ObjectFactory) {
    val endpoint = Endpoint(objectFactory, JsonObject(mutableMapOf()))

    fun proxyUrl(uri: URI?): EndpointBuilder {
        endpoint.proxyUrl += uri ?: return this
        return this
    }

    fun proxyUrl(proxyUrlList: List<URI?>?): EndpointBuilder {
        endpoint.proxyUrl += proxyUrlList.orEmpty().filterNotNull()
        return this
    }

    fun proxyUrl(string: String?): EndpointBuilder {
        proxyUrl(URI(string ?: return this))
        return this
    }

    fun oauthAuthorizationEndpoint(uri: URI?): EndpointBuilder {
        endpoint.oauthAuthorizationEndpoint += uri ?: return this
        return this
    }

    fun oauthAuthorizationEndpoint(proxyUrlList: List<URI?>?): EndpointBuilder {
        endpoint.oauthAuthorizationEndpoint += proxyUrlList.orEmpty().filterNotNull()
        return this
    }

    fun oauthAuthorizationEndpoint(string: String?): EndpointBuilder {
        oauthAuthorizationEndpoint(URI(string ?: return this))
        return this
    }

    fun oauthTokenEndpoint(uri: URI?): EndpointBuilder {
        endpoint.oauthTokenEndpoint += uri ?: return this
        return this
    }

    fun oauthTokenEndpoint(proxyUrlList: List<URI?>?): EndpointBuilder {
        endpoint.oauthTokenEndpoint += proxyUrlList.orEmpty().filterNotNull()
        return this
    }

    fun oauthTokenEndpoint(string: String?): EndpointBuilder {
        oauthTokenEndpoint(URI(string ?: return this))
        return this
    }

    fun provideClientKey(uri: URI?): EndpointBuilder {
        endpoint.provideClientKey += uri ?: return this
        return this
    }

    fun provideClientKey(proxyUrlList: List<URI?>?): EndpointBuilder {
        endpoint.provideClientKey += proxyUrlList.orEmpty().filterNotNull()
        return this
    }

    fun provideClientKey(string: String?): EndpointBuilder {
        provideClientKey(URI(string ?: return this))
        return this
    }

    fun signClientKey(uri: URI?): EndpointBuilder {
        endpoint.signClientKey += uri ?: return this
        return this
    }

    fun signClientKey(proxyUrlList: List<URI?>?): EndpointBuilder {
        endpoint.signClientKey += proxyUrlList.orEmpty().filterNotNull()
        return this
    }

    fun signClientKey(string: String?): EndpointBuilder {
        signClientKey(URI(string ?: return this))
        return this
    }

    fun sharedInbox(uri: URI?): EndpointBuilder {
        endpoint.sharedInbox += uri ?: return this
        return this
    }

    fun sharedInbox(proxyUrlList: List<URI?>?): EndpointBuilder {
        endpoint.sharedInbox += proxyUrlList.orEmpty().filterNotNull()
        return this
    }

    fun sharedInbox(string: String?): EndpointBuilder {
        sharedInbox(URI(string ?: return this))
        return this
    }
}