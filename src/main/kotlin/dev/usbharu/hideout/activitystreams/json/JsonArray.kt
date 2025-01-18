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
        return "[$array]"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as JsonArray

        if (array != other.array) return false
        if (type != other.type) return false

        return true
    }

    override fun hashCode(): Int {
        var result = array.hashCode()
        result = 31 * result + type.hashCode()
        return result
    }


}

fun List<JsonNode>.toJsonArray(): JsonArray {
    return JsonArray(toMutableList())
}