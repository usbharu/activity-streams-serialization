package dev.usbharu.activitystreamsserialization.dsl

import dev.usbharu.activitystreamsserialization.activity.Type
import dev.usbharu.activitystreamsserialization.activity.pub.ActivityPubObjectFactory
import dev.usbharu.activitystreamsserialization.activity.pub.ActivityPubPerson
import dev.usbharu.activitystreamsserialization.activity.pub.Endpoint
import dev.usbharu.activitystreamsserialization.other.LangString
import dev.usbharu.activitystreamsserialization.other.ObjectFactory
import dev.usbharu.activitystreamsserialization.other.create
import java.net.URI

class PersonBuilder(objectFactory: ObjectFactory = ActivityPubObjectFactory, ldBuilder: JsonLdBuilder) :
    ObjectBuilder(objectFactory, ldBuilder) {

    val iObj = objectFactory.create<ActivityPubPerson>(Type.PERSON)

    override val Object: ActivityPubPerson
        get() = iObj

    fun inbox(uri: URI?): PersonBuilder {
        Object.inbox += uri ?: return this
        return this
    }

    fun inbox(uriList: List<URI?>?): PersonBuilder {
        Object.inbox = uriList.orEmpty().filterNotNull()
        return this
    }

    fun outbox(uri: URI?): PersonBuilder {
        Object.outbox += uri ?: return this
        return this
    }

    fun outbox(uriList: List<URI?>?): PersonBuilder {
        Object.outbox = uriList.orEmpty().filterNotNull()
        return this
    }

    fun following(uri: URI?): PersonBuilder {
        Object.following += uri ?: return this
        return this
    }

    fun following(uriList: List<URI?>?): PersonBuilder {
        Object.following = uriList.orEmpty().filterNotNull()
        return this
    }

    fun followers(uri: URI?): PersonBuilder {
        Object.followers += uri ?: return this
        return this
    }

    fun followers(uriList: List<URI?>?): PersonBuilder {
        Object.followers = uriList.orEmpty().filterNotNull()
        return this
    }

    fun liked(uri: URI?): PersonBuilder {
        Object.liked += uri ?: return this
        return this
    }

    fun liked(uriList: List<URI?>?): PersonBuilder {
        Object.liked = uriList.orEmpty().filterNotNull()
        return this
    }

    fun streams(uri: URI?): PersonBuilder {
        Object.streams += uri ?: return this
        return this
    }

    fun streams(uriList: List<URI?>?): PersonBuilder {
        Object.streams = uriList.orEmpty().filterNotNull()
        return this
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

    fun endpoints(endpointBuilder: EndpointBuilder.() -> List<Endpoint>): PersonBuilder {
        val endpointBuilder1 = EndpointBuilder().endpointBuilder()
        endpoints(endpointBuilder1)
        return this
    }
}