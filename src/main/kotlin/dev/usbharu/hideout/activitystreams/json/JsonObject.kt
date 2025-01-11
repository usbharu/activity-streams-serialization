package dev.usbharu.hideout.activitystreams.json

class JsonObject(private val map: MutableMap<String, JsonNode>) : JsonNode, MutableMap<String, JsonNode> by map {
    override val type: NodeType
        get() = NodeType.Object

    fun obtain(key: String): JsonNode? {
        val get = get(key)
        if (get != null) {
            return get
        }
        if (key.startsWith("http://")) {
            return get(key.replaceFirst("http://", "https://"))
        } else if (key.startsWith("https://")) {
            return get(key.replaceFirst("https://", "http://"))
        }
        return null
    }

    fun setOrRemove(key: String, value: JsonNode?) {
        if (value == null) {
            map.remove(key)
            return
        }
        map[key] = value
    }

    override fun toString(): String {
        return "{${map.entries.joinToString { "\"${it.key}\":${it.value}" }}}"
    }


}