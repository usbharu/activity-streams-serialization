package dev.usbharu.hideout.activitystreams.json

interface JsonNode {
    val type: NodeType
    val isArray: Boolean
        get() = type == NodeType.Array

    val isObject: Boolean
        get() = type == NodeType.Object

    val isLiteral: Boolean
        get() = type == NodeType.Literal

    val isNull: Boolean
        get() = type == NodeType.Null

    fun isTypeOf(type: NodeType): Boolean {
        return this.type == type
    }

    fun asArrayOrNull(): JsonArray? {
        if (isArray.not()) {
            return null
        }
        return this as? JsonArray
    }

    fun asArray(): JsonArray {
        return JsonArray.by(this)
    }

    fun asObjectOrNull(): JsonObject? {
        if (isObject.not()) {
            return null
        }
        return this as? JsonObject
    }

    fun asLiteralOrNull(): JsonLiteral? {
        if (isLiteral.not()) {
            return null
        }
        return this as? JsonLiteral
    }

    fun asStringLiteralOrNull(): JsonString? {
        if (isLiteral.not()) {
            return null
        }
        return this as? JsonString
    }
}