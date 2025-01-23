package dev.usbharu.activitystreamsserialization.dsl

import dev.usbharu.activitystreamsserialization.activity.pub.ActivityPubObjectFactory
import org.junit.jupiter.api.Test

class DslTest {
    @Test
    fun personBuilder() {
        JsonLdBuilder(ActivityPubObjectFactory).Person {

        }
    }
}