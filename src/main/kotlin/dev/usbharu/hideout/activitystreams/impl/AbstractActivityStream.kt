package dev.usbharu.hideout.activitystreams.impl

import dev.usbharu.hideout.activitystreams.JsonLd

abstract class AbstractActivityStream : AbstractActor, AbstractActivity, AbstractCore, AbstractObject, JsonLd {
    override fun isObject(): Boolean {
        return isActor() || isActivity() || isCore() || isObject2()
    }


}