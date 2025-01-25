package dev.usbharu.activitystreamsserialization.dsl

import dev.usbharu.activitystreamsserialization.model.Type
import dev.usbharu.activitystreamsserialization.model.activitypub.Endpoint
import dev.usbharu.activitystreamsserialization.model.actor.Person
import dev.usbharu.activitystreamsserialization.model.impl.DefaultObjectFactory
import dev.usbharu.activitystreamsserialization.model.w3idsecurity.Key
import dev.usbharu.activitystreamsserialization.other.LangString
import dev.usbharu.activitystreamsserialization.other.ObjectFactory
import dev.usbharu.activitystreamsserialization.other.create
import java.net.URI

class PersonBuilder(objectFactory: ObjectFactory = DefaultObjectFactory, activityBuilder: ActivityBuilder) :
    ObjectBuilder(objectFactory, activityBuilder) {

    override val Object: Person = objectFactory.create<Person>(Type.PERSON)


    fun inbox(uri: URI?): PersonBuilder {
        Object.inbox += uri ?: return this
        return this
    }

    fun inbox(uriList: List<URI?>?): PersonBuilder {
        Object.inbox = uriList.orEmpty().filterNotNull()
        return this
    }

    fun inbox(string: String?): PersonBuilder {
        return inbox(URI.create(string ?: return this))
    }

    fun outbox(uri: URI?): PersonBuilder {
        Object.outbox += uri ?: return this
        return this
    }

    fun outbox(uriList: List<URI?>?): PersonBuilder {
        Object.outbox = uriList.orEmpty().filterNotNull()
        return this
    }

    fun outbox(string: String?): PersonBuilder {
        return outbox(URI.create(string ?: return this))
    }

    fun following(uri: URI?): PersonBuilder {
        Object.following += uri ?: return this
        return this
    }

    fun following(uriList: List<URI?>?): PersonBuilder {
        Object.following = uriList.orEmpty().filterNotNull()
        return this
    }

    fun following(string: String?): PersonBuilder {
        return following(URI.create(string ?: return this))
    }

    fun followers(uri: URI?): PersonBuilder {
        Object.followers += uri ?: return this
        return this
    }

    fun followers(uriList: List<URI?>?): PersonBuilder {
        Object.followers = uriList.orEmpty().filterNotNull()
        return this
    }

    fun followers(string: String?): PersonBuilder {
        return followers(URI.create(string ?: return this))
    }

    fun liked(uri: URI?): PersonBuilder {
        Object.liked += uri ?: return this
        return this
    }

    fun liked(uriList: List<URI?>?): PersonBuilder {
        Object.liked = uriList.orEmpty().filterNotNull()
        return this
    }

    fun liked(string: String?): PersonBuilder {
        return liked(URI.create(string ?: return this))
    }

    fun streams(uri: URI?): PersonBuilder {
        Object.streams += uri ?: return this
        return this
    }

    fun streams(uriList: List<URI?>?): PersonBuilder {
        Object.streams = uriList.orEmpty().filterNotNull()
        return this
    }

    fun streams(string: String?): PersonBuilder {
        return streams(URI.create(string ?: return this))
    }

    fun preferredUsername(langString: LangString?): PersonBuilder {
        Object.preferredUsername += langString ?: return this
        return this
    }

    fun preferredUsername(langStringList: List<LangString?>?): PersonBuilder {
        Object.preferredUsername = langStringList.orEmpty().filterNotNull()
        return this
    }

    fun preferredUsername(defaultLangString: String): PersonBuilder {
        Object.preferredUsername += LangString(value = defaultLangString)
        return this
    }

    fun endpoints(endpoint: Endpoint?): PersonBuilder {
        Object.endpoints += endpoint ?: return this
        return this
    }

    fun endpoints(endpointList: List<Endpoint?>?): PersonBuilder {
        Object.endpoints = endpointList.orEmpty().filterNotNull()
        return this
    }

    fun endpoints(block: EndpointsBuilder.() -> List<Endpoint> = { emptyList() }): PersonBuilder {
        val endpointList = EndpointsBuilder(objectFactory).block()
        endpoints(endpointList)
        return this
    }

    fun manuallyApprovesFollowers(boolean: Boolean?): PersonBuilder {
        Object.manuallyApprovesFollowers = boolean
        return this
    }

    fun discoverable(boolean: Boolean?): PersonBuilder {
        Object.discoverable = boolean
        return this
    }

    fun featured(boolean: Boolean?): PersonBuilder {
        Object.featured = boolean
        return this
    }

    fun publicKey(key: Key?): PersonBuilder {
        Object.publicKey += key ?: return this
        return this
    }

    fun publicKey(keyList: List<Key?>?): PersonBuilder {
        Object.publicKey = keyList.orEmpty().filterNotNull()
        return this
    }

    fun publicKey(block: KeysBuilder.() -> List<Key> = { emptyList() }): PersonBuilder {
        val keysBuilder = KeysBuilder()
        val keyList = keysBuilder.block()
        publicKey(keyList)
        return this
    }
}