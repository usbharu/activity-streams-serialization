package dev.usbharu.hideout.activitystreams

interface ObjectOrLink : JsonLd {
    fun isObject(): Boolean
    fun isLink(): Boolean
}

fun List<ObjectOrLink>.objects(): List<Object> {
    return this.filter { it.isObject() }.map { it as Object }
}

fun List<ObjectOrLink>.links(): List<ObjectOrLink> { //todo linkに変える
    return this.filter { it.isLink() }
}