import com.github.jsonldjava.core.JsonLdProcessor
import com.github.jsonldjava.utils.JsonUtils
import dev.usbharu.hideout.activitystreams.JsonLd
import dev.usbharu.hideout.activitystreams.json.JsonArray
import dev.usbharu.hideout.activitystreams.json.impl.KotlinxSerializationConverter
import kotlinx.serialization.json.Json
import kotlin.test.assertEquals

fun preprocess(string: String): JsonArray {
    val toString = expand(string)
    return KotlinxSerializationConverter.convert(Json.parseToJsonElement(toString)).asArray()
}

fun expand(string: String): String {
    return JsonUtils.toString(JsonLdProcessor.expand(JsonUtils.fromString(string)))
}

fun assertObjects(jsonLd: JsonLd, string: String) {
    val expected = expand(string)
    val encodeToString = Json.encodeToString(KotlinxSerializationConverter.convert(jsonLd.json))
    val actual = expand(encodeToString)
    assertEquals(Json.parseToJsonElement(expected), Json.parseToJsonElement(actual))
}