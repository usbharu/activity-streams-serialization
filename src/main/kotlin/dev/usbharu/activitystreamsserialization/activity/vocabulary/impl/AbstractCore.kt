package dev.usbharu.activitystreamsserialization.activity.vocabulary.impl

import dev.usbharu.activitystreamsserialization.activity.Type
import dev.usbharu.activitystreamsserialization.activity.vocabulary.core.*

interface AbstractCore : Activity, IntransitiveActivity, ActivityOrRelationship,
    dev.usbharu.activitystreamsserialization.activity.vocabulary.core.Collection, CollectionOrLink,
    CollectionPage, CollectionPageOrLink, ImageOrLink, Link, Object, ObjectOrLink, ObjectOrLinkOrDateTimeOrBoolean,
    OrderedCollection, OrderedCollectionPage, UriOrLink {
    fun isCore(): Boolean {
        return type.contains(Type.ACTIVITY) ||
                type.contains(Type.INTRANSITIVE_ACTIVITY) ||
                type.contains(Type.COLLECTION) ||
                type.contains(Type.COLLECTION_PAGE) ||
                type.contains(Type.LIKE) ||
                type.contains(Type.OBJECT) ||
                type.contains(Type.ORDERED_COLLECTION) ||
                type.contains(Type.ORDERED_COLLECTION_PAGE)
    }
}