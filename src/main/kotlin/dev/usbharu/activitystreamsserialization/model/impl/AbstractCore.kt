package dev.usbharu.activitystreamsserialization.model.impl

import dev.usbharu.activitystreamsserialization.model.Type
import dev.usbharu.activitystreamsserialization.model.core.*
import dev.usbharu.activitystreamsserialization.model.core.Collection

interface AbstractCore : Activity, IntransitiveActivity, ActivityOrRelationship,
    Collection, CollectionOrLink,
    CollectionPage, CollectionPageOrLink, ImageOrLink, Link, dev.usbharu.activitystreamsserialization.model.core.Object,
    ObjectOrLink, ObjectOrLinkOrDateTimeOrBoolean,
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