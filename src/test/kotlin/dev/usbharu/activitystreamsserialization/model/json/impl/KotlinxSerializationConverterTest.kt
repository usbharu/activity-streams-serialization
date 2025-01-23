package dev.usbharu.activitystreamsserialization.model.json.impl

import com.github.jsonldjava.core.JsonLdProcessor
import com.github.jsonldjava.utils.JsonUtils
import dev.usbharu.activitystreamsserialization.json.impl.KotlinxSerializationConverter
import dev.usbharu.activitystreamsserialization.model.Type
import dev.usbharu.activitystreamsserialization.model.core.attachment
import dev.usbharu.activitystreamsserialization.model.core.filterBy
import dev.usbharu.activitystreamsserialization.model.core.items
import dev.usbharu.activitystreamsserialization.model.impl.DefaultObjectFactory
import dev.usbharu.activitystreamsserialization.model.`object`.Note
import dev.usbharu.activitystreamsserialization.other.asTypeOfNull
import dev.usbharu.activitystreamsserialization.other.create
import dev.usbharu.activitystreamsserialization.other.getAsMap
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

    @Test
    fun test2() {
        val fromString = JsonUtils.fromString(
            """{
  "@context": ["https://www.w3.org/ns/activitystreams",
               {"@language": "ja"}],
  "type": "Person",
  "id": "https://kenzoishii.example.com/",
  "following": "https://kenzoishii.example.com/following.json",
  "followers": "https://kenzoishii.example.com/followers.json",
  "liked": "https://kenzoishii.example.com/liked.json",
  "inbox": "https://kenzoishii.example.com/inbox.json",
  "outbox": "https://kenzoishii.example.com/feed.json",
  "preferredUsername": "kenzoishii",
  "name": "石井健蔵",
  "summary": "この方はただの例です",
  "icon": [
    "https://kenzoishii.example.com/image/165987aklre4"
  ]
}"""
        )

        val expand = JsonLdProcessor.expand(fromString)
        println(JsonUtils.toPrettyString(expand))
    }
}