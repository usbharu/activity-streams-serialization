package dev.usbharu.activitystreamsserialization.dsl

import dev.usbharu.activitystreamsserialization.activity.pub.ActivityPubObjectFactory
import org.junit.jupiter.api.Test
import java.net.URI

class DslTest {
    @Test
    fun personBuilder() {
        val person = JsonLdBuilder(ActivityPubObjectFactory).Person {
            endpoints {
                listOf(
                    Endpoint {
                        sharedInbox(URI.create("https://examples.com"))
                    }
                )
            }
        }

        println(person)
    }
}