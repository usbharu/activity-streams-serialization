package dev.usbharu.activitystreamsserialization.activity.pub

import dev.usbharu.activitystreamsserialization.activity.Properties
import dev.usbharu.activitystreamsserialization.activity.vocabulary.core.Collection
import dev.usbharu.activitystreamsserialization.activity.vocabulary.core.Object
import dev.usbharu.activitystreamsserialization.activity.vocabulary.core.OrderedCollection
import dev.usbharu.activitystreamsserialization.json.JsonObject
import dev.usbharu.activitystreamsserialization.json.toJsonArray
import dev.usbharu.activitystreamsserialization.other.JsonLd
import dev.usbharu.activitystreamsserialization.other.LangString

interface ActivityPubActor : Object, JsonLd {
    var inbox: List<OrderedCollection>
        get() {
            val jsonNode = jsonObject.obtain(Properties.INBOX) ?: return emptyList()
            return jsonNode.asArray().map { objectFactory.create(it) as OrderedCollection }
        }
        set(value) {
            jsonObject.setOrRemove(
                Properties.INBOX, value.map { it.json }.toJsonArray()
            )
        }
    var outbox: List<OrderedCollection>
        get() {
            val jsonNode = jsonObject.obtain(Properties.OUTBOX) ?: return emptyList()
            return jsonNode.asArray().map { objectFactory.create(it) as OrderedCollection }
        }
        set(value) {
            jsonObject.setOrRemove(
                Properties.OUTBOX, value.map { it.json }.toJsonArray()
            )
        }
    var following: List<Collection>
        get() {
            val jsonNode = jsonObject.obtain(Properties.FOLLOWING) ?: return emptyList()
            return jsonNode.asArray().map { objectFactory.create(it) as OrderedCollection }
        }
        set(value) {
            jsonObject.setOrRemove(
                Properties.FOLLOWING, value.map { it.json }.toJsonArray()
            )
        }
    var followers: List<Collection>
        get() {
            val jsonNode = jsonObject.obtain(Properties.FOLLOWERS) ?: return emptyList()
            return jsonNode.asArray().map { objectFactory.create(it) as OrderedCollection }
        }
        set(value) {
            jsonObject.setOrRemove(
                Properties.FOLLOWERS, value.map { it.json }.toJsonArray()
            )
        }
    var liked: List<Collection>
        get() {
            val jsonNode = jsonObject.obtain(Properties.LIKED) ?: return emptyList()
            return jsonNode.asArray().map { objectFactory.create(it) as Collection }
        }
        set(value) {
            jsonObject.setOrRemove(
                Properties.LIKED, value.map { it.json }.toJsonArray()
            )
        }
    var streams: List<Collection>
        get() {
            val jsonNode = jsonObject.obtain(Properties.STREAMS) ?: return emptyList()
            return jsonNode.asArray().map { objectFactory.create(it) as Collection }
        }
        set(value) {
            jsonObject.setOrRemove(
                Properties.STREAMS, value.map { it.json }.toJsonArray()
            )
        }
    var preferredUsername: List<LangString>
        get() {
            val jsonNode = jsonObject.obtain(Properties.PREFERRED_USERNAME) ?: return emptyList()

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
                Properties.PREFERRED_USERNAME, value.map { it.toJsonObject() }.toJsonArray()
            )
        }
    var endpoints: List<Endpoint>
        get() {
            val jsonNode = jsonObject.obtain(Properties.ENDPOINTS) ?: return emptyList()
            return jsonNode.asArray().map { Endpoint(objectFactory, json) }
        }
        set(value) {
            jsonObject.setOrRemove(
                Properties.ENDPOINTS, value.map { it.json }.toJsonArray()
            )
        }
}