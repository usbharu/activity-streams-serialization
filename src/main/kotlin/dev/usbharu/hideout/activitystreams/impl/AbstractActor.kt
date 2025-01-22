package dev.usbharu.hideout.activitystreams.impl

import dev.usbharu.hideout.activitystreams.Type
import dev.usbharu.hideout.activitystreams.actor.*

interface AbstractActor : Application, Group, Organization, Person, Service {
    fun isActor(): Boolean {
        return type.contains(Type.PERSON) ||
                type.contains(Type.APPLICATION) ||
                type.contains(Type.GROUP) ||
                type.contains(Type.SERVICE) ||
                type.contains(Type.ORGANIZATION)
    }
}