package dev.usbharu.activitystreamsserialization.activity.vocabulary.impl

import dev.usbharu.activitystreamsserialization.activity.Type
import dev.usbharu.activitystreamsserialization.activity.vocabulary.`object`.*


interface AbstractObject : Article, Document, Event, Image, Note, Page, Place, Profile, Relationship, Tombstone,
    Video {
    fun isObject2(): Boolean {
        return type.contains(Type.ARTICLE) ||
                type.contains(Type.AUDIO) ||
                type.contains(Type.DOCUMENT) ||
                type.contains(Type.EVENT) ||
                type.contains(Type.IMAGE) ||
                type.contains(Type.NOTE) ||
                type.contains(Type.PAGE) ||
                type.contains(Type.PLACE) ||
                type.contains(Type.PROFILE) ||
                type.contains(Type.RELATIONSHIP) ||
                type.contains(Type.TOMBSTONE) ||
                type.contains(Type.VIDEO) ||
                type.contains(Type.MENTION)

    }
}