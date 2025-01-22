package dev.usbharu.activitystreamsserialization.dsl

import dev.usbharu.activitystreamsserialization.activity.Type
import dev.usbharu.activitystreamsserialization.activity.vocabulary.actor.Person
import dev.usbharu.activitystreamsserialization.activity.vocabulary.impl.DefaultObjectFactory
import dev.usbharu.activitystreamsserialization.other.ObjectFactory
import dev.usbharu.activitystreamsserialization.other.create

class PersonBuilder(objectFactory: ObjectFactory = DefaultObjectFactory, ldBuilder: JsonLdBuilder) :
    ObjectBuilder(objectFactory, ldBuilder) {

    val iObj = objectFactory.create<Person>(Type.PERSON)

    override val Object: Person
        get() = iObj
}