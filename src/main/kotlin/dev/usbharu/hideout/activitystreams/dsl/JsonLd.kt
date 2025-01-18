package dev.usbharu.hideout.activitystreams.dsl

import dev.usbharu.hideout.activitystreams.ObjectFactory
import dev.usbharu.hideout.activitystreams.actor.Person
import dev.usbharu.hideout.activitystreams.core.Object
import dev.usbharu.hideout.activitystreams.impl.DefaultObjectFactory
import dev.usbharu.hideout.activitystreams.`object`.Image
import dev.usbharu.hideout.activitystreams.`object`.Note

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
}

