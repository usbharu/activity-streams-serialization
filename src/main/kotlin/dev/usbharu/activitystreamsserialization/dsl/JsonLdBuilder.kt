package dev.usbharu.activitystreamsserialization.dsl

import dev.usbharu.activitystreamsserialization.activity.Properties
import dev.usbharu.activitystreamsserialization.activity.vocabulary.actor.Person
import dev.usbharu.activitystreamsserialization.activity.vocabulary.core.Link
import dev.usbharu.activitystreamsserialization.activity.vocabulary.core.Object
import dev.usbharu.activitystreamsserialization.activity.vocabulary.impl.DefaultObjectFactory
import dev.usbharu.activitystreamsserialization.activity.vocabulary.`object`.Image
import dev.usbharu.activitystreamsserialization.activity.vocabulary.`object`.Note
import dev.usbharu.activitystreamsserialization.json.JsonObject
import dev.usbharu.activitystreamsserialization.json.JsonString
import dev.usbharu.activitystreamsserialization.other.ObjectFactory

class JsonLdBuilder(var objectFactory: ObjectFactory = DefaultObjectFactory) {
    fun Object(block: ObjectBuilder.() -> Unit = {}): Object {
        val objectBuilder = ObjectBuilder(objectFactory, this)
        objectBuilder.block()
        return objectBuilder.Object
    }

    fun Note(block: NoteBuilder.() -> Unit = {}): Note {
        val objectBuilder = NoteBuilder(objectFactory, this)
        objectBuilder.block()
        return objectBuilder.Object
    }

    fun Image(block: ImageBuilder.() -> Unit = {}): Image {
        val objectBuilder = ImageBuilder(objectFactory, this)
        objectBuilder.block()
        return objectBuilder.Object
    }

    fun Person(block: PersonBuilder.() -> Unit): Person {
        val objectBuilder = PersonBuilder(objectFactory, this)
        objectBuilder.block()
        return objectBuilder.Object
    }

    fun Link(string: String): Link {
        return objectFactory.create(JsonObject(mutableMapOf(Properties.ID to JsonString(string)))) as Link

    }
}

