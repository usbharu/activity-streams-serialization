package dev.usbharu.hideout.activitystreams.impl

import dev.usbharu.hideout.activitystreams.core.*
import dev.usbharu.hideout.activitystreams.core.Collection

interface AbstractCore : Activity, IntransitiveActivity, ActivityOrRelationship, Collection, CollectionOrLink,
    CollectionPage, CollectionPageOrLink, ImageOrLink, Link, Object, ObjectOrLink, ObjectOrLinkOrDateTimeOrBoolean,
    OrderedCollection, OrderedCollectionPage, UriOrLink