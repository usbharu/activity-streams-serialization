package dev.usbharu.hideout.activitystreams.json.impl

import dev.usbharu.hideout.activitystreams.Activity
import dev.usbharu.hideout.activitystreams.Object
import dev.usbharu.hideout.activitystreams.ObjectFactory
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Test

class KotlinxSerializationImplTest {
    @Test
    fun name() {

        val jsonElement = Json.parseToJsonElement(
            """
            [
              {
                "@type": [
                  "https://www.w3.org/ns/activitystreams#Create"
                ],
                "https://www.w3.org/ns/activitystreams#actor": [
                  {
                    "@id": "acct:sally@example.org",
                    "@type": [
                      "https://www.w3.org/ns/activitystreams#Person"
                    ],
                    "https://www.w3.org/ns/activitystreams#name": [
                      {
                        "@value": "aa",
                        "@language": "ja"
                      }
                    ]
                  }
                ],
                "https://www.w3.org/ns/activitystreams#object": [
                  {
                    "@type": [
                      "https://www.w3.org/ns/activitystreams#Note"
                    ],
                    "https://www.w3.org/ns/activitystreams#content": [
                      {
                        "@value": "This is a simple note"
                      }
                    ]
                  }
                ],
                "https://www.w3.org/ns/activitystreams#published": [
                  {
                    "@type": "http://www.w3.org/2001/XMLSchema#dateTime",
                    "@value": "2015-01-25T12:34:56Z"
                  }
                ]
              }
            ]
        """.trimIndent()
        )
        val convert = KotlinxSerializationImpl.convert(jsonElement)
        println(convert)

        val factory = ObjectFactory.factory(convert.asArray()[0])
        val activity = factory as Activity
        val actor = activity.actor
        println(actor)
        println(actor.map { it.type })
        println(activity.type)
        println(activity.`object`)
        println(activity.`object`.map { it as Object }.map { it.content })
        println(activity.published)
    }
}