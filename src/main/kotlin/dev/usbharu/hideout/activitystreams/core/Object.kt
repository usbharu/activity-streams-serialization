package dev.usbharu.hideout.activitystreams.core

import dev.usbharu.hideout.activitystreams.JsonLd
import dev.usbharu.hideout.activitystreams.ObjectFactory
import dev.usbharu.hideout.activitystreams.Properties
import dev.usbharu.hideout.activitystreams.Type
import dev.usbharu.hideout.activitystreams.impl.DefaultObjectFactory
import dev.usbharu.hideout.activitystreams.json.JsonObject
import dev.usbharu.hideout.activitystreams.json.JsonString
import dev.usbharu.hideout.activitystreams.json.toJsonArray
import dev.usbharu.hideout.activitystreams.other.LangString
import dev.usbharu.hideout.activitystreams.other.Uri
import java.time.OffsetDateTime
import javax.xml.datatype.DatatypeFactory
import javax.xml.datatype.Duration

interface Object : ObjectOrLink, JsonLd {

    var attachment: List<ObjectOrLink>
        get() = attachment()
        set(value) = setAsObjectOrLink(Properties.ATTACHMENT, value)

    var audience: List<ObjectOrLink>
        get() = audience()
        set(value) = setAsObjectOrLink(Properties.AUDIENCE, value)

    var context: List<ObjectOrLink>
        get() = getAsObjectOrLink(Properties.CONTEXT)
        set(value) = setAsObjectOrLink(Properties.CONTEXT, value)

    var endTime: OffsetDateTime?
        get() = getOffsetDataTime(Properties.END_TIME)
        set(value) = setOffsetDateTime(value, Properties.END_TIME)

    var generator: List<ObjectOrLink>
        get() = generator()
        set(value) = setAsObjectOrLink(Properties.GENERATOR, value)

    var icon: List<ImageOrLink>
        get() = icon()
        set(value) = setAsObjectOrLink(Properties.ICON, value)

    var image: List<ImageOrLink>
        get() = image()
        set(value) = setAsObjectOrLink(Properties.IMAGE, value)

    var inReplyTo: List<ObjectOrLink>
        get() = inReplyTo()
        set(value) = setAsObjectOrLink(Properties.IN_REPLY_TO, value)

    var location: List<ObjectOrLink>
        get() = getAsObjectOrLink(Properties.LOCATION)
        set(value) = setAsObjectOrLink(Properties.LOCATION, value)

    var replies: Collection?
        get() = replies()
        set(value) {
            jsonObject.setOrRemove(Properties.REPLIES, value?.json)
        }

    var startTime: OffsetDateTime?
        get() = getOffsetDataTime(Properties.START_TIME)
        set(value) = setOffsetDateTime(value, Properties.START_TIME)

    var summary: List<LangString>
        get() {
            val jsonNode = jsonObject.obtain(Properties.SUMMARY) ?: return emptyList()

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
                Properties.SUMMARY,
                value.map { it.toJsonObject() }.toJsonArray()
            )
        }

    var tag: List<ObjectOrLink>
        get() = tag()
        set(value) = setAsObjectOrLink(Properties.TAG, value)

    var updated: OffsetDateTime?
        get() = getOffsetDataTime(Properties.UPDATED)
        set(value) = setOffsetDateTime(value, Properties.UPDATED)

    var url: List<UriOrLink>
        get() {
            val jsonNode = jsonObject.obtain(Properties.URL) ?: return emptyList()
            return jsonNode.asArray().map {
                require(it.isObject)
                it as JsonObject
                if (it[Properties.TYPE] == JsonString(Type.LINK)) {
                    DefaultObjectFactory.create(it) as Link
                } else {
                    Uri(it)
                }
            }
        }
        set(value) {
            jsonObject.setOrRemove(
                Properties.URL,
                value.map { it.json }.toJsonArray()
            )
        }

    var to: List<ObjectOrLink>
        get() = to()
        set(value) = setAsObjectOrLink(Properties.TO, value)

    var bto: List<ObjectOrLink>
        get() = bto()
        set(value) = setAsObjectOrLink(Properties.BTO, value)

    var cc: List<ObjectOrLink>
        get() = cc()
        set(value) = setAsObjectOrLink(Properties.CC, value)

    var bcc: List<ObjectOrLink>
        get() = bcc()
        set(value) = setAsObjectOrLink(Properties.BCC, value)

    var published: OffsetDateTime?
        get() {
            return getOffsetDataTime(Properties.PUBLISHED)
        }
        set(value) {
            setOffsetDateTime(value, Properties.PUBLISHED)
        }

    var duration: Duration?
        get() {
            val jsonNode = jsonObject.obtain(Properties.DURATION) ?: return null
            return DatatypeFactory.newInstance().newDuration(jsonNode.asStringLiteralOrNull()?.value ?: return null)
        }
        set(value) {
            jsonObject.setOrRemove(Properties.DURATION, value?.toString()?.let { JsonString(it) })
        }

    fun setOffsetDateTime(value: OffsetDateTime?, key: String) {
        if (value == null) {
            jsonObject.remove(key)
        }
        jsonObject.setOrRemove(
            key, listOf(
                JsonObject(
                    mutableMapOf(
                        Properties.TYPE to JsonString("http://www.w3.org/2001/XMLSchema#dateTime"),
                        Properties.VALUE to JsonString(
                            value.toString()
                        )
                    )
                )
            ).toJsonArray()
        )
    }

    fun getOffsetDataTime(key: String): OffsetDateTime? {
        val jsonNode = jsonObject.obtain(key) ?: return null
        return jsonNode.asArray().firstNotNullOf {
            require(it.isObject)
            it as JsonObject
            if (it[Properties.TYPE] != JsonString("http://www.w3.org/2001/XMLSchema#dateTime")) {
                null
            } else {
                OffsetDateTime.parse(it[Properties.VALUE]?.asStringLiteralOrNull()?.value.toString())
            }
        }
    }


    var content: List<LangString>
        get() {
            val jsonNode = jsonObject.obtain(Properties.CONTENT) ?: return emptyList()

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
                Properties.CONTENT,
                value.map { it.toJsonObject() }.toJsonArray()
            )
        }
}

fun Object?.attachment(objectFactory: ObjectFactory? = this?.objectFactory): List<ObjectOrLink> {
    if (this == null) {
        return emptyList()
    }
    requireNotNull(objectFactory)
    return getAsObjectOrLink(Properties.ATTACHMENT, objectFactory)
}

fun Object?.replies(objectFactory: ObjectFactory? = this?.objectFactory): Collection? {
    if (this == null) {
        return null
    }
    requireNotNull(objectFactory)
    val jsonNode = jsonObject.obtain(Properties.REPLIES)?.asArray()?.firstOrNull() ?: return null
    require(jsonNode.isObject)
    return objectFactory.create(jsonNode) as Collection
}

fun Object?.audience(objectFactory: ObjectFactory? = this?.objectFactory): List<ObjectOrLink> {
    if (this == null) {
        return emptyList()
    }
    requireNotNull(objectFactory)
    return getAsObjectOrLink(Properties.AUDIENCE, objectFactory)
}

fun Object?.context(objectFactory: ObjectFactory? = this?.objectFactory): List<ObjectOrLink> {
    if (this == null) {
        return emptyList()
    }
    requireNotNull(objectFactory)
    return getAsObjectOrLink(Properties.CONTEXT, objectFactory)
}

fun Object?.generator(objectFactory: ObjectFactory? = this?.objectFactory): List<ObjectOrLink> {
    if (this == null) {
        return emptyList()
    }
    requireNotNull(objectFactory)
    return getAsObjectOrLink(Properties.GENERATOR, objectFactory)
}

fun Object?.icon(objectFactory: ObjectFactory? = this?.objectFactory): List<ImageOrLink> {
    if (this == null) {
        return emptyList()
    }
    requireNotNull(objectFactory)
    val jsonNode = jsonObject.obtain(Properties.ICON) ?: return emptyList()
    return jsonNode.asArray().map { DefaultObjectFactory.create(it) as ImageOrLink }
}

fun Object?.image(objectFactory: ObjectFactory? = this?.objectFactory): List<ImageOrLink> {
    if (this == null) {
        return emptyList()
    }
    requireNotNull(objectFactory)
    val jsonNode = jsonObject.obtain(Properties.IMAGE) ?: return emptyList()
    return jsonNode.asArray().map { DefaultObjectFactory.create(it) as ImageOrLink }
}

fun Object?.inReplyTo(objectFactory: ObjectFactory? = this?.objectFactory): List<ObjectOrLink> {
    if (this == null) {
        return emptyList()
    }
    requireNotNull(objectFactory)
    return getAsObjectOrLink(Properties.IN_REPLY_TO, objectFactory)
}

fun Object?.location(objectFactory: ObjectFactory? = this?.objectFactory): List<ObjectOrLink> {
    if (this == null) {
        return emptyList()
    }
    requireNotNull(objectFactory)
    return getAsObjectOrLink(Properties.LOCATION, objectFactory)
}

fun Object?.tag(objectFactory: ObjectFactory? = this?.objectFactory): List<ObjectOrLink> {
    if (this == null) {
        return emptyList()
    }
    requireNotNull(objectFactory)
    return getAsObjectOrLink(Properties.TAG, objectFactory)
}

fun Object?.to(objectFactory: ObjectFactory? = this?.objectFactory): List<ObjectOrLink> {
    if (this == null) {
        return emptyList()
    }
    requireNotNull(objectFactory)
    return getAsObjectOrLink(Properties.TO, objectFactory)
}

fun Object?.bto(objectFactory: ObjectFactory? = this?.objectFactory): List<ObjectOrLink> {
    if (this == null) {
        return emptyList()
    }
    requireNotNull(objectFactory)
    return getAsObjectOrLink(Properties.BTO, objectFactory)
}


fun Object?.cc(objectFactory: ObjectFactory? = this?.objectFactory): List<ObjectOrLink> {
    if (this == null) {
        return emptyList()
    }
    requireNotNull(objectFactory)
    return getAsObjectOrLink(Properties.CC, objectFactory)
}

fun Object?.bcc(objectFactory: ObjectFactory? = this?.objectFactory): List<ObjectOrLink> {
    if (this == null) {
        return emptyList()
    }
    requireNotNull(objectFactory)
    return getAsObjectOrLink(Properties.BCC, objectFactory)
}