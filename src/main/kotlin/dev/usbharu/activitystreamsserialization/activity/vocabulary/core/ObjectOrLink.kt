package dev.usbharu.activitystreamsserialization.activity.vocabulary.core


import dev.usbharu.activitystreamsserialization.activity.Properties
import dev.usbharu.activitystreamsserialization.json.JsonObject
import dev.usbharu.activitystreamsserialization.json.JsonString
import dev.usbharu.activitystreamsserialization.json.toJsonArray
import dev.usbharu.activitystreamsserialization.other.JsonLd
import dev.usbharu.activitystreamsserialization.other.LangString
import dev.usbharu.activitystreamsserialization.other.asTypeOfNull

interface ObjectOrLink : JsonLd, ObjectOrLinkOrDateTimeOrBoolean {
    fun isObject(): Boolean
    fun isLink(): Boolean

    var attributedTo: List<ObjectOrLink>
        get() = getAsObjectOrLink(Properties.ATTRIBUTED_TO)
        set(value) = setAsObjectOrLink(Properties.ATTRIBUTED_TO, value)

    var preview: List<ObjectOrLink>
        get() = getAsObjectOrLink(Properties.PREVIEW)
        set(value) = setAsObjectOrLink(Properties.PREVIEW, value)

    var mediaType: String?
        get() = jsonObject.obtain(Properties.MEDIA_TYPE)?.asStringLiteralOrNull()?.value
        set(value) = jsonObject.setOrRemove(Properties.MEDIA_TYPE, value?.let { JsonString(it) })

    var name: List<LangString>
        get() {
            val jsonNode = jsonObject.obtain(Properties.NAME) ?: return emptyList()

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
                Properties.NAME,
                value.map { it.toJsonObject() }.toJsonArray()
            )
        }
}

fun List<ObjectOrLink>.objects(): List<Object> {
    return this.filter { it.isObject() }.map { it as Object }
}

fun List<ObjectOrLink>.links(): List<Link> {
    return this.filter { it.isLink() }.map { it as Link }
}

inline fun <reified T : JsonLd> List<ObjectOrLink>.filterBy(type: String): List<T> {
    return this.mapNotNull { it.asTypeOfNull(type) }
}