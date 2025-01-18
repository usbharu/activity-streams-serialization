package dev.usbharu.hideout.activitystreams.dsl

import dev.usbharu.hideout.activitystreams.ObjectFactory
import dev.usbharu.hideout.activitystreams.Type
import dev.usbharu.hideout.activitystreams.create
import dev.usbharu.hideout.activitystreams.impl.DefaultObjectFactory
import dev.usbharu.hideout.activitystreams.`object`.Image

class ImageBuilder(objectFactory: ObjectFactory = DefaultObjectFactory, ldBuilder: JsonLdBuilder) :
    ObjectBuilder(objectFactory, ldBuilder) {

    val iObj = objectFactory.create<Image>(Type.IMAGE)

    override val Object: Image
        get() = iObj
}