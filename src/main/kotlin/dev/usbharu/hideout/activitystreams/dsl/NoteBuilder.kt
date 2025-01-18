package dev.usbharu.hideout.activitystreams.dsl

import dev.usbharu.hideout.activitystreams.ObjectFactory
import dev.usbharu.hideout.activitystreams.Type
import dev.usbharu.hideout.activitystreams.create
import dev.usbharu.hideout.activitystreams.impl.DefaultObjectFactory
import dev.usbharu.hideout.activitystreams.`object`.Note

class NoteBuilder(objectFactory: ObjectFactory = DefaultObjectFactory, ldBuilder: JsonLdBuilder) :
    ObjectBuilder(objectFactory, ldBuilder) {

    val iObj = objectFactory.create<Note>(Type.NOTE)
    override val Object: Note
        get() = iObj
}