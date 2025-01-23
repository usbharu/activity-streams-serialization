package dev.usbharu.activitystreamsserialization.dsl

import org.junit.jupiter.api.Test
import java.net.URI

class DslTest {
    @Test
    fun personBuilder() {
        val person = JsonLdBuilder().Person {
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