package dev.usbharu.activitystreamsserialization.dsl

import dev.usbharu.activitystreamsserialization.model.Type
import dev.usbharu.activitystreamsserialization.model.impl.DefaultObjectFactory
import dev.usbharu.activitystreamsserialization.model.`object`.Note
import dev.usbharu.activitystreamsserialization.other.ObjectFactory
import dev.usbharu.activitystreamsserialization.other.create

class NoteBuilder(objectFactory: ObjectFactory = DefaultObjectFactory, activityBuilder: ActivityBuilder) :
    ObjectBuilder(objectFactory, activityBuilder) {

    val iObj = objectFactory.create<Note>(Type.NOTE)
    override val Object: Note
        get() = iObj
}