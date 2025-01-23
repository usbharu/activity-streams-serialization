package dev.usbharu.activitystreamsserialization.model.impl

import dev.usbharu.activitystreamsserialization.model.activitypub.AbstractActivityPub
import dev.usbharu.activitystreamsserialization.other.JsonLd

abstract class AbstractActivityVocabulary : AbstractActor, AbstractActivity, AbstractCore, AbstractObject, JsonLd,
    AbstractActivityPub {
    override fun isObject(): Boolean {
        return isActor() || isActivity() || isCore() || isObject2()
    }


}