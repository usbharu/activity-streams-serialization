package dev.usbharu.activitystreamsserialization.dsl

import dev.usbharu.activitystreamsserialization.model.Type
import dev.usbharu.activitystreamsserialization.model.impl.DefaultObjectFactory
import dev.usbharu.activitystreamsserialization.model.`object`.Image
import dev.usbharu.activitystreamsserialization.other.ObjectFactory
import dev.usbharu.activitystreamsserialization.other.create

class ImageBuilder(objectFactory: ObjectFactory = DefaultObjectFactory, activityBuilder: ActivityBuilder) :
    ObjectBuilder(objectFactory, activityBuilder) {

    val iObj = objectFactory.create<Image>(Type.IMAGE)

    override val Object: Image
        get() = iObj
}