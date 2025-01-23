package dev.usbharu.activitystreamsserialization.model.impl

import dev.usbharu.activitystreamsserialization.model.Type
import dev.usbharu.activitystreamsserialization.model.actor.*

interface AbstractActor : Application, Group, Organization, Person, Service {
    fun isActor(): Boolean {
        return type.contains(Type.PERSON) ||
                type.contains(Type.APPLICATION) ||
                type.contains(Type.GROUP) ||
                type.contains(Type.SERVICE) ||
                type.contains(Type.ORGANIZATION)
    }
}