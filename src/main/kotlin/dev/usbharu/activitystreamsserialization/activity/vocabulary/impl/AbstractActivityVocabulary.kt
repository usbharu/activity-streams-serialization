package dev.usbharu.activitystreamsserialization.activity.vocabulary.impl

import dev.usbharu.activitystreamsserialization.other.JsonLd

abstract class AbstractActivityVocabulary : AbstractActor, AbstractActivity, AbstractCore, AbstractObject, JsonLd {
    override fun isObject(): Boolean {
        return isActor() || isActivity() || isCore() || isObject2()
    }


}