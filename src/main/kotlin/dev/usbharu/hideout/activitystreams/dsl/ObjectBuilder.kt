package dev.usbharu.hideout.activitystreams.dsl

import dev.usbharu.hideout.activitystreams.ObjectFactory
import dev.usbharu.hideout.activitystreams.Properties
import dev.usbharu.hideout.activitystreams.Type
import dev.usbharu.hideout.activitystreams.core.Link
import dev.usbharu.hideout.activitystreams.core.Object
import dev.usbharu.hideout.activitystreams.core.ObjectOrLink
import dev.usbharu.hideout.activitystreams.core.UriOrLink
import dev.usbharu.hideout.activitystreams.create
import dev.usbharu.hideout.activitystreams.impl.DefaultObjectFactory
import dev.usbharu.hideout.activitystreams.json.JsonObject
import dev.usbharu.hideout.activitystreams.json.JsonString
import dev.usbharu.hideout.activitystreams.other.LangString
import dev.usbharu.hideout.activitystreams.other.Uri
import java.net.URI
import java.time.OffsetDateTime


open class ObjectBuilder(
    var objectFactory: ObjectFactory = DefaultObjectFactory, private val ldBuilder: JsonLdBuilder
) {

    open val Object = objectFactory.create<Object>(Type.OBJECT)

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

    fun endTime(endTime: OffsetDateTime?): ObjectBuilder {
        Object.endTime = endTime
        return this
    }
}