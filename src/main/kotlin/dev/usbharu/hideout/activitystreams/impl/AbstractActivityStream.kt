package dev.usbharu.hideout.activitystreams.impl

import dev.usbharu.hideout.activitystreams.JsonLd
import dev.usbharu.hideout.activitystreams.core.Object
import dev.usbharu.hideout.activitystreams.link.Mention
import dev.usbharu.hideout.activitystreams.`object`.Image
import dev.usbharu.hideout.activitystreams.`object`.Note

abstract class AbstractActivityStream : AbstractActor, AbstractActivity, AbstractCore, AbstractObject, JsonLd, Object,
    Image, Note,
    Mention {
    override fun isObject(): Boolean {
        return true //todo
    }


}