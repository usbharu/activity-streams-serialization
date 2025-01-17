package dev.usbharu.hideout.activitystreams.json.impl

import dev.usbharu.hideout.activitystreams.*
import dev.usbharu.hideout.activitystreams.core.attachment
import dev.usbharu.hideout.activitystreams.core.filterBy
import dev.usbharu.hideout.activitystreams.core.items
import dev.usbharu.hideout.activitystreams.impl.DefaultObjectFactory
import dev.usbharu.hideout.activitystreams.`object`.Note
import dev.usbharu.hideout.activitystreams.other.getAsMap
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Test
import java.net.URI

class KotlinxSerializationConverterTest {
    @Test
    fun name() {

        val jsonElement = Json.parseToJsonElement(
            """
         [
  {
    "https://www.w3.org/ns/activitystreams#content": [
      {
        "@value": "I am fine."
      }
    ],
    "@id": "http://www.test.example/notes/1",
    "https://www.w3.org/ns/activitystreams#replies": [
      {
        "https://www.w3.org/ns/activitystreams#items": [
          {
            "https://www.w3.org/ns/activitystreams#content": [
              {
                "@value": "I am glad to hear it."
              }
            ],
            "https://www.w3.org/ns/activitystreams#inReplyTo": [
              {
                "@id": "http://www.test.example/notes/1"
              }
            ],
            "https://www.w3.org/ns/activitystreams#summary": [
              {
                "@value": "A response to the note"
              }
            ],
            "@type": [
              "https://www.w3.org/ns/activitystreams#Note"
            ]
          }
        ],
        "https://www.w3.org/ns/activitystreams#totalItems": [
          {
            "@type": "http://www.w3.org/2001/XMLSchema#nonNegativeInteger",
            "@value": 1
          }
        ],
        "@type": [
          "https://www.w3.org/ns/activitystreams#Collection"
        ]
      }
    ],
    "https://www.w3.org/ns/activitystreams#summary": [
      {
        "@value": "A simple note"
      }
    ],
    "@type": [
      "https://www.w3.org/ns/activitystreams#Note"
    ]
  }
]
        """.trimIndent()
        )
        val convert = KotlinxSerializationConverter.convert(jsonElement)
        println(convert)

        val factory = DefaultObjectFactory.create(convert.asArray()[0])
        val note = factory.asTypeOfNull<Note>(Type.NOTE) ?: return
        println(note.content.getAsMap()["default"])
        println(note.attachment())
        println(note.summary)
        println(note.id)
        println(note.replies)
        println(note.replies?.totalItems)
        println(note.replies.items)
        note
            .replies
            .items
            .filterBy<Note>(Type.NOTE)
            .map {
                println(it.summary)
                println(it.type)
                println(it.content)
                it.inReplyTo.map {
                    println(it.id)
                }
            }

    }

    @Test
    fun create() {
        val create = DefaultObjectFactory.create<Note>(Type.NOTE)

        create.id = URI.create("https://examples.com")

        val convert = KotlinxSerializationConverter.convert(create.json)

        println(Json.encodeToString(convert))
    }
}