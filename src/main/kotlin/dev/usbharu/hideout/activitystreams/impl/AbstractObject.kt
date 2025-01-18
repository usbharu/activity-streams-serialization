package dev.usbharu.hideout.activitystreams.impl

import dev.usbharu.hideout.activitystreams.`object`.*

interface AbstractObject : Article, Document, Event, Image, Note, Page, Place, Profile, Relationship, Tombstone,
    Video {}