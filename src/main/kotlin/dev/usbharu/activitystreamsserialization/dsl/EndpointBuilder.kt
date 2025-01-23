package dev.usbharu.activitystreamsserialization.dsl

import dev.usbharu.activitystreamsserialization.activity.pub.Endpoint
import dev.usbharu.activitystreamsserialization.json.JsonObject
import dev.usbharu.activitystreamsserialization.other.ObjectFactory
import java.net.URI

class EndpointBuilder(var objectFactory: ObjectFactory) {
    val endpoints = Endpoint(objectFactory, JsonObject(mutableMapOf()))

    fun proxyUrl(uri: URI?): EndpointBuilder {
        endpoints.proxyUrl += uri ?: return this
        return this
    }

    fun proxyUrl(proxyUrlList: List<URI?>?): EndpointBuilder {
        endpoints.proxyUrl += proxyUrlList.orEmpty().filterNotNull()
        return this
    }

    fun oauthAuthorizationEndpoint(uri: URI?): EndpointBuilder {
        endpoints.oauthAuthorizationEndpoint += uri ?: return this
        return this
    }

    fun oauthAuthorizationEndpoint(proxyUrlList: List<URI?>?): EndpointBuilder {
        endpoints.oauthAuthorizationEndpoint += proxyUrlList.orEmpty().filterNotNull()
        return this
    }

    fun oauthTokenEndpoint(uri: URI?): EndpointBuilder {
        endpoints.oauthTokenEndpoint += uri ?: return this
        return this
    }

    fun oauthTokenEndpoint(proxyUrlList: List<URI?>?): EndpointBuilder {
        endpoints.oauthTokenEndpoint += proxyUrlList.orEmpty().filterNotNull()
        return this
    }

    fun provideClientKey(uri: URI?): EndpointBuilder {
        endpoints.provideClientKey += uri ?: return this
        return this
    }

    fun provideClientKey(proxyUrlList: List<URI?>?): EndpointBuilder {
        endpoints.provideClientKey += proxyUrlList.orEmpty().filterNotNull()
        return this
    }

    fun signClientKey(uri: URI?): EndpointBuilder {
        endpoints.signClientKey += uri ?: return this
        return this
    }

    fun signClientKey(proxyUrlList: List<URI?>?): EndpointBuilder {
        endpoints.signClientKey += proxyUrlList.orEmpty().filterNotNull()
        return this
    }

    fun sharedInbox(uri: URI?): EndpointBuilder {
        endpoints.sharedInbox += uri ?: return this
        return this
    }

    fun sharedInbox(proxyUrlList: List<URI?>?): EndpointBuilder {
        endpoints.sharedInbox += proxyUrlList.orEmpty().filterNotNull()
        return this
    }
}