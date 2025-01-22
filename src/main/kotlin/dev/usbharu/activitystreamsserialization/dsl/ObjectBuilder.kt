package dev.usbharu.activitystreamsserialization.dsl

import dev.usbharu.activitystreamsserialization.activity.Properties
import dev.usbharu.activitystreamsserialization.activity.Type
import dev.usbharu.activitystreamsserialization.activity.vocabulary.core.Link
import dev.usbharu.activitystreamsserialization.activity.vocabulary.core.Object
import dev.usbharu.activitystreamsserialization.activity.vocabulary.core.ObjectOrLink
import dev.usbharu.activitystreamsserialization.activity.vocabulary.core.UriOrLink
import dev.usbharu.activitystreamsserialization.activity.vocabulary.impl.DefaultObjectFactory
import dev.usbharu.activitystreamsserialization.json.JsonObject
import dev.usbharu.activitystreamsserialization.json.JsonString
import dev.usbharu.activitystreamsserialization.other.LangString
import dev.usbharu.activitystreamsserialization.other.ObjectFactory
import dev.usbharu.activitystreamsserialization.other.Uri
import dev.usbharu.activitystreamsserialization.other.create
import java.net.URI
import java.time.OffsetDateTime


open class ObjectBuilder(
    var objectFactory: ObjectFactory = DefaultObjectFactory, private val ldBuilder: JsonLdBuilder
) {

    open val Object = objectFactory.create<Object>(Type.OBJECT)

    fun id(uri: URI?): ObjectBuilder {
        Object.id = uri
        return this
    }

    fun id(string: String?): ObjectBuilder {
        id(URI.create(string ?: return this))
        return this
    }

    fun attachment(objectOrLink: ObjectOrLink?): ObjectBuilder {
        Object.attachment += objectOrLink ?: return this
        return this
    }

    fun attachment(objectOrLinkList: List<ObjectOrLink?>?): ObjectBuilder {
        Object.attachment = objectOrLinkList.orEmpty().filterNotNull()
        return this
    }

    fun attachment(objectOrLinkBuilder: JsonLdBuilder.() -> List<ObjectOrLink>): ObjectBuilder {
        val objectOrLinkBuilder1 = ldBuilder.objectOrLinkBuilder()
        attachment(objectOrLinkBuilder1)
        return this
    }

    fun content(langString: LangString?): ObjectBuilder {
        Object.content += langString ?: return this
        return this
    }

    fun content(langStringList: List<LangString?>?): ObjectBuilder {
        Object.content = langStringList.orEmpty().filterNotNull()
        return this
    }

    fun content(defaultLangString: String): ObjectBuilder {
        Object.content += LangString(value = defaultLangString)
        return this
    }

    fun url(uri: UriOrLink?): ObjectBuilder {
        Object.url += uri ?: return this
        return this
    }

    fun url(uri: URI?): ObjectBuilder {
        Object.url += Uri.fromURI(uri ?: return this)
        return this
    }

    fun url(url: String?): ObjectBuilder {
        return url(URI.create(url ?: return this))
    }

    fun name(langString: LangString?): ObjectBuilder {
        Object.name += langString ?: return this
        return this
    }

    fun name(langStringList: List<LangString?>?): ObjectBuilder {
        Object.name = langStringList.orEmpty().filterNotNull()
        return this
    }

    fun name(defaultLangString: String): ObjectBuilder {
        Object.name += LangString(value = defaultLangString)
        return this
    }

    fun attributedTo(string: String?): ObjectBuilder {
        Object.attributedTo += objectFactory.create(
            JsonObject(
                mutableMapOf(
                    Properties.ID to JsonString(
                        string ?: return this
                    )
                )
            )
        ) as Link
        return this
    }

    fun attributedTo(objectOrLink: ObjectOrLink?): ObjectBuilder {
        Object.attributedTo += objectOrLink ?: return this
        return this
    }

    fun attributedTo(objectOrLinkList: List<ObjectOrLink?>?): ObjectBuilder {
        Object.attributedTo = objectOrLinkList.orEmpty().filterNotNull()
        return this
    }

    fun attributedTo(objectOrLinkBuilder: JsonLdBuilder.() -> List<ObjectOrLink>): ObjectBuilder {
        val objectOrLinkBuilder1 = ldBuilder.objectOrLinkBuilder()
        attributedTo(objectOrLinkBuilder1)
        return this
    }

    fun audience(objectOrLink: ObjectOrLink?): ObjectBuilder {
        Object.audience += objectOrLink ?: return this
        return this
    }

    fun audience(objectOrLinkList: List<ObjectOrLink?>?): ObjectBuilder {
        Object.audience = objectOrLinkList.orEmpty().filterNotNull()
        return this
    }

    fun audience(objectOrLinkBuilder: JsonLdBuilder.() -> List<ObjectOrLink>): ObjectBuilder {
        val objectOrLinkBuilder1 = ldBuilder.objectOrLinkBuilder()
        audience(objectOrLinkBuilder1)
        return this
    }

    fun context(objectOrLink: ObjectOrLink?): ObjectBuilder {
        Object.context += objectOrLink ?: return this
        return this
    }

    fun context(objectOrLinkList: List<ObjectOrLink?>?): ObjectBuilder {
        Object.context = objectOrLinkList.orEmpty().filterNotNull()
        return this
    }

    fun context(objectOrLinkBuilder: JsonLdBuilder.() -> List<ObjectOrLink>): ObjectBuilder {
        val objectOrLinkBuilder1 = ldBuilder.objectOrLinkBuilder()
        context(objectOrLinkBuilder1)
        return this
    }

    fun generator(objectOrLink: ObjectOrLink?): ObjectBuilder {
        Object.generator += objectOrLink ?: return this
        return this
    }

    fun generator(objectOrLinkList: List<ObjectOrLink?>?): ObjectBuilder {
        Object.generator = objectOrLinkList.orEmpty().filterNotNull()
        return this
    }

    fun generator(objectOrLinkBuilder: JsonLdBuilder.() -> List<ObjectOrLink>): ObjectBuilder {
        val objectOrLinkBuilder1 = ldBuilder.objectOrLinkBuilder()
        generator(objectOrLinkBuilder1)
        return this
    }

    fun inReplyTo(objectOrLink: ObjectOrLink?): ObjectBuilder {
        Object.inReplyTo += objectOrLink ?: return this
        return this
    }

    fun inReplyTo(objectOrLinkList: List<ObjectOrLink?>?): ObjectBuilder {
        Object.inReplyTo = objectOrLinkList.orEmpty().filterNotNull()
        return this
    }

    fun inReplyTo(objectOrLinkBuilder: JsonLdBuilder.() -> List<ObjectOrLink>): ObjectBuilder {
        val objectOrLinkBuilder1 = ldBuilder.objectOrLinkBuilder()
        inReplyTo(objectOrLinkBuilder1)
        return this
    }

    fun location(objectOrLink: ObjectOrLink?): ObjectBuilder {
        Object.location += objectOrLink ?: return this
        return this
    }

    fun location(objectOrLinkList: List<ObjectOrLink?>?): ObjectBuilder {
        Object.location = objectOrLinkList.orEmpty().filterNotNull()
        return this
    }

    fun location(objectOrLinkBuilder: JsonLdBuilder.() -> List<ObjectOrLink>): ObjectBuilder {
        val objectOrLinkBuilder1 = ldBuilder.objectOrLinkBuilder()
        location(objectOrLinkBuilder1)
        return this
    }

    fun tag(objectOrLink: ObjectOrLink?): ObjectBuilder {
        Object.tag += objectOrLink ?: return this
        return this
    }

    fun tag(objectOrLinkList: List<ObjectOrLink?>?): ObjectBuilder {
        Object.tag = objectOrLinkList.orEmpty().filterNotNull()
        return this
    }

    fun tag(objectOrLinkBuilder: JsonLdBuilder.() -> List<ObjectOrLink>): ObjectBuilder {
        val objectOrLinkBuilder1 = ldBuilder.objectOrLinkBuilder()
        tag(objectOrLinkBuilder1)
        return this
    }

    fun to(objectOrLink: ObjectOrLink?): ObjectBuilder {
        Object.to += objectOrLink ?: return this
        return this
    }

    fun to(objectOrLinkList: List<ObjectOrLink?>?): ObjectBuilder {
        Object.to = objectOrLinkList.orEmpty().filterNotNull()
        return this
    }

    fun to(objectOrLinkBuilder: JsonLdBuilder.() -> List<ObjectOrLink>): ObjectBuilder {
        val objectOrLinkBuilder1 = ldBuilder.objectOrLinkBuilder()
        to(objectOrLinkBuilder1)
        return this
    }

    fun bto(objectOrLink: ObjectOrLink?): ObjectBuilder {
        Object.bto += objectOrLink ?: return this
        return this
    }

    fun bto(objectOrLinkList: List<ObjectOrLink?>?): ObjectBuilder {
        Object.bto = objectOrLinkList.orEmpty().filterNotNull()
        return this
    }

    fun bto(objectOrLinkBuilder: JsonLdBuilder.() -> List<ObjectOrLink>): ObjectBuilder {
        val objectOrLinkBuilder1 = ldBuilder.objectOrLinkBuilder()
        bto(objectOrLinkBuilder1)
        return this
    }

    fun cc(objectOrLink: ObjectOrLink?): ObjectBuilder {
        Object.cc += objectOrLink ?: return this
        return this
    }

    fun cc(objectOrLinkList: List<ObjectOrLink?>?): ObjectBuilder {
        Object.cc = objectOrLinkList.orEmpty().filterNotNull()
        return this
    }

    fun cc(objectOrLinkBuilder: JsonLdBuilder.() -> List<ObjectOrLink>): ObjectBuilder {
        val objectOrLinkBuilder1 = ldBuilder.objectOrLinkBuilder()
        cc(objectOrLinkBuilder1)
        return this
    }

    fun bcc(objectOrLink: ObjectOrLink?): ObjectBuilder {
        Object.bcc += objectOrLink ?: return this
        return this
    }

    fun bcc(objectOrLinkList: List<ObjectOrLink?>?): ObjectBuilder {
        Object.bcc = objectOrLinkList.orEmpty().filterNotNull()
        return this
    }

    fun bcc(objectOrLinkBuilder: JsonLdBuilder.() -> List<ObjectOrLink>): ObjectBuilder {
        val objectOrLinkBuilder1 = ldBuilder.objectOrLinkBuilder()
        bcc(objectOrLinkBuilder1)
        return this
    }

    fun endTime(endTime: OffsetDateTime?): ObjectBuilder {
        Object.endTime = endTime
        return this
    }

    fun endTime(string: String?): ObjectBuilder {
        endTime(OffsetDateTime.parse(string ?: return this))
        return this
    }

}