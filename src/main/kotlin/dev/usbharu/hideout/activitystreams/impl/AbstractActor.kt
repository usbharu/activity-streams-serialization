package dev.usbharu.hideout.activitystreams.impl

import dev.usbharu.hideout.activitystreams.actor.Application
import dev.usbharu.hideout.activitystreams.actor.Group
import dev.usbharu.hideout.activitystreams.actor.Person
import dev.usbharu.hideout.activitystreams.actor.Service

interface AbstractActor : Application, Group, Person, Service {
}