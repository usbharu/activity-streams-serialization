package dev.usbharu.activitystreamsserialization.activity.pub

import checkDeserialize
import dev.usbharu.activitystreamsserialization.activity.vocabulary.actor.Person
import org.junit.jupiter.api.Test

class ActivityPubActorTest {
    @Test
    fun person() {
        val actor = checkDeserialize<ActivityPubActor>(
            """[
  {
    "https://www.w3.org/ns/activitystreams#followers": [
      {
        "@id": "https://kenzoishii.example.com/followers.json"
      }
    ],
    "https://www.w3.org/ns/activitystreams#following": [
      {
        "@id": "https://kenzoishii.example.com/following.json"
      }
    ],
    "https://www.w3.org/ns/activitystreams#icon": [
      {
        "@id": "https://kenzoishii.example.com/image/165987aklre4"
      }
    ],
    "@id": "https://kenzoishii.example.com/",
    "http://www.w3.org/ns/ldp#inbox": [
      {
        "@id": "https://kenzoishii.example.com/inbox.json"
      }
    ],
    "https://www.w3.org/ns/activitystreams#liked": [
      {
        "@id": "https://kenzoishii.example.com/liked.json"
      }
    ],
    "https://www.w3.org/ns/activitystreams#name": [
      {
        "@language": "ja",
        "@value": "石井健蔵"
      }
    ],
    "https://www.w3.org/ns/activitystreams#outbox": [
      {
        "@id": "https://kenzoishii.example.com/feed.json"
      }
    ],
    "https://www.w3.org/ns/activitystreams#preferredUsername": [
      {
        "@language": "ja",
        "@value": "kenzoishii"
      }
    ],
    "https://www.w3.org/ns/activitystreams#summary": [
      {
        "@language": "ja",
        "@value": "この方はただの例です"
      }
    ],
    "@type": [
      "https://www.w3.org/ns/activitystreams#Person"
    ]
  }
]""", "https://www.w3.org/ns/activitystreams#Person", ActivityPubObjectFactory
        )

        println(actor.id)
        println(actor.following)
        println(actor.followers)
        println(actor.liked)
        println(actor.inbox)
        println(actor.outbox)
        println(actor.preferredUsername)
        val person = actor as Person
        println(person.name)
        println(person.summary)
        println(person.icon)

    }
}