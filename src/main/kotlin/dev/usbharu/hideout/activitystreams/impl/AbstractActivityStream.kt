package dev.usbharu.hideout.activitystreams.impl

import dev.usbharu.hideout.activitystreams.*
import dev.usbharu.hideout.activitystreams.Collection

abstract class AbstractActivityStream : Activity, JsonLd, Object, ObjectOrLink, CollectionPage, Collection,
    OrderedCollection, OrderedCollectionPage, Image, ImageOrLink, UriOrLink, Link, Note {
    override fun isObject(): Boolean {
        return true //todo
    }


}