package dev.usbharu.hideout.activitystreams.dsl

import dev.usbharu.hideout.activitystreams.ObjectFactory
import dev.usbharu.hideout.activitystreams.Type
import dev.usbharu.hideout.activitystreams.actor.Person
import dev.usbharu.hideout.activitystreams.create
import dev.usbharu.hideout.activitystreams.impl.DefaultObjectFactory

class PersonBuilder(objectFactory: ObjectFactory = DefaultObjectFactory, ldBuilder: JsonLdBuilder) :
    ObjectBuilder(objectFactory, ldBuilder) {

    val iObj = objectFactory.create<Person>(Type.PERSON)

    override val Object: Person
        get() = iObj
}