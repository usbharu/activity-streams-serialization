package dev.usbharu.hideout.activitystreams.json

sealed class JsonLiteral : JsonNode {
    override val type: NodeType
        get() = NodeType.Literal
    abstract val valueAsString: String
}

data class JsonString(val value: String) : JsonLiteral() {
    override val valueAsString: String
        get() = value

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as JsonString

        return value == other.value
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }


}

data class JsonNumber(val value: Double) : JsonLiteral() {
    override val valueAsString: String
        get() = value.toString()
}

data class JsonBoolean(val value: Boolean) : JsonLiteral() {
    override val valueAsString: String
        get() = value.toString()
}

object JsonNull : JsonNode, JsonLiteral() {
    override val type: NodeType
        get() = NodeType.Null
    override val valueAsString: String
        get() = "null"
}