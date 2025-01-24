package dev.usbharu.activitystreamsserialization.model.actor

import dev.usbharu.activitystreamsserialization.model.activitypub.ActivityPubActor
import dev.usbharu.activitystreamsserialization.model.core.Object
import dev.usbharu.activitystreamsserialization.model.joinmastodon.MastodonActor
import dev.usbharu.activitystreamsserialization.model.w3idsecurity.W3idSecurityActor

interface Service : Object, ActivityPubActor, W3idSecurityActor, MastodonActor {
}