package dev.usbharu.hideout.activitystreams.core

import assertObjects
import checkDeserialize
import dev.usbharu.hideout.activitystreams.Type
import dev.usbharu.hideout.activitystreams.asTypeOfNull
import dev.usbharu.hideout.activitystreams.create
import dev.usbharu.hideout.activitystreams.dsl.JsonLdBuilder
import dev.usbharu.hideout.activitystreams.impl.DefaultObjectFactory
import dev.usbharu.hideout.activitystreams.other.LangString
import dev.usbharu.hideout.activitystreams.other.defaultOrNull
import org.junit.jupiter.api.Test
import preprocess
import java.net.URI
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class ObjectTest {

    @Test
    fun deserializeObject() {
        val preprocess = preprocess(
            """{
  "@context": "https://www.w3.org/ns/activitystreams",
  "type": "Object",
  "id": "http://www.test.example/object/1",
  "name": "A Simple, non-specific object"
}"""
        )[0]

        val jsonLd = DefaultObjectFactory.create(preprocess)

        val objectOrNull = jsonLd.asTypeOfNull<Object>(Type.OBJECT)

        assertNotNull(objectOrNull)
        assertEquals(URI.create("http://www.test.example/object/1"), objectOrNull.id)
        assertEquals("A Simple, non-specific object", objectOrNull.name.defaultOrNull())
    }

    @Test
    fun serializeObject() {
        val objects = DefaultObjectFactory.create<Object>(Type.OBJECT)
        objects.id = URI.create("http://www.test.example/object/1")
        objects.name += LangString(value = "A Simple, non-specific object")

        assertObjects(
            objects, """{
  "@context": "https://www.w3.org/ns/activitystreams",
  "type": "Object",
  "id": "http://www.test.example/object/1",
  "name": "A Simple, non-specific object"
}"""
        )
    }

    @Test
    fun deserializeAttachment() {
        val checkDeserialize = checkDeserialize<Object>(
            """{
  "@context": "https://www.w3.org/ns/activitystreams",
  "type": "Object",
  "attachment": [
    {
      "type": "Object"
    }
  ]
}""", Type.OBJECT
        )

        assertContentEquals(listOf(JsonLdBuilder().Object()), checkDeserialize.attachment)
    }

    @Test
    fun serializeAttachment() {
        val object1 = JsonLdBuilder().Note {
            attachment {
                listOf(
                    Image {
                        content("This is what he looks like.")
                        url("http://example.org/cat.jpeg")
                    })
            }
            name("Have you seen my cat?")
        }

        assertObjects(
            object1, """{
  "@context": "https://www.w3.org/ns/activitystreams",
  "type": "Note",
  "name": "Have you seen my cat?",
  "attachment": [
    {
      "type": "Image",
      "content": "This is what he looks like.",
      "url": "http://example.org/cat.jpeg"
    }
  ]
}"""
        )
    }

    @Test
    fun deserializeAttributedTo1() {
        val deserialize = checkDeserialize<Object>(
            """{
  "@context": "https://www.w3.org/ns/activitystreams",
  "type": "Object",
  "attributedTo": [
    {
      "type": "Object"
    }
  ]
}""", Type.OBJECT
        )

        assertContentEquals(listOf(JsonLdBuilder().Object()), deserialize.attributedTo)

    }
}