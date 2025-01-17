package dev.usbharu.hideout.activitystreams.impl

import dev.usbharu.hideout.activitystreams.Image
import dev.usbharu.hideout.activitystreams.JsonLd
import dev.usbharu.hideout.activitystreams.Note
import dev.usbharu.hideout.activitystreams.core.*
import dev.usbharu.hideout.activitystreams.core.Collection

abstract class AbstractActivityStream : Activity, JsonLd, Object, ObjectOrLink, CollectionPage, Collection,
    OrderedCollection, OrderedCollectionPage, Image, ImageOrLink, UriOrLink, Link, Note {
    override fun isObject(): Boolean {
        return true //todo
    }


}