package dev.usbharu.activitystreamsserialization.dsl

import dev.usbharu.activitystreamsserialization.json.JsonObject
import dev.usbharu.activitystreamsserialization.json.JsonString
import dev.usbharu.activitystreamsserialization.model.Properties
import dev.usbharu.activitystreamsserialization.model.actor.Person
import dev.usbharu.activitystreamsserialization.model.core.Link
import dev.usbharu.activitystreamsserialization.model.core.Object
import dev.usbharu.activitystreamsserialization.model.impl.DefaultObjectFactory
import dev.usbharu.activitystreamsserialization.model.`object`.Image
import dev.usbharu.activitystreamsserialization.model.`object`.Note
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

