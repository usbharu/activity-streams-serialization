package dev.usbharu.activitystreamsserialization.dsl

import dev.usbharu.activitystreamsserialization.activity.ObjectFactory
import dev.usbharu.activitystreamsserialization.activity.Type
import dev.usbharu.activitystreamsserialization.activity.create
import dev.usbharu.activitystreamsserialization.activity.vocabulary.actor.Person
import dev.usbharu.activitystreamsserialization.activity.vocabulary.impl.DefaultObjectFactory

class PersonBuilder(objectFactory: ObjectFactory = DefaultObjectFactory, ldBuilder: JsonLdBuilder) :
    ObjectBuilder(objectFactory, ldBuilder) {

    val iObj = objectFactory.create<Person>(Type.PERSON)

    override val Object: Person
        get() = iObj
}