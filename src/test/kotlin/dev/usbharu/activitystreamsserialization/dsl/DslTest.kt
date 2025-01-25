package dev.usbharu.activitystreamsserialization.dsl

import org.junit.jupiter.api.Test
import java.net.URI

class DslTest {
    @Test
    fun personBuilder() {
        val person = ActivityBuilder().Person {
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

    @Test
    fun image() {
        ActivityBuilder().Person {
            icon {
                listOf(
                    Image {
                        url("https://www.examples.com")
                    }
                )
            }
        }
    }

    @Test
    fun actor() {

        val person = ActivityBuilder().Person {
            name("name")
            id("https://example.com/id")
            preferredUsername("preferredUsername")
            inbox(URI.create("https://example.com/inbox"))
            outbox(URI.create("https://example.com/outbox"))
            following(URI.create("https://example.com/following"))
            followers(URI.create("https://example.com/followers"))
            publicKey {
                listOf(
                    Key {
                        owner("https://example.com/owner-id")
                        id("https://example.com/owner-id-key")
                        publicKeyPem("--key--")
                    }
                )
            }
            icon {
                listOf(
                    Image {
                        url("https://www.examples.com/icon")
                    }
                )
            }
            imageWith {
                url("https://www.examples.com/image")
            }
        }

        println(person.json)
    }
}