package dev.usbharu.hideout.activitystreams.json

class JsonArray(private val array: MutableList<JsonNode>) : JsonNode, MutableList<JsonNode> by array {
    override val type: NodeType
        get() = NodeType.Array

    companion object {
        fun by(node: JsonNode): JsonArray {
            return if (node.isArray) {
                node as JsonArray
            } else if (node.isNull) {
                JsonArray(mutableListOf())
            } else {
                JsonArray(mutableListOf(node))
            }
        }
    }

    override fun toString(): String {
        return "JsonArray(" +
                "array=$array, " +
                "type=$type" +
                ")"
    }


}

fun List<JsonNode>.toJsonArray(): JsonArray {
    return JsonArray(toMutableList())
}