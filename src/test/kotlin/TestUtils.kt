
import com.github.jsonldjava.core.JsonLdProcessor
import com.github.jsonldjava.utils.JsonUtils
import dev.usbharu.activitystreamsserialization.activity.vocabulary.impl.DefaultObjectFactory
import dev.usbharu.activitystreamsserialization.json.JsonArray
import dev.usbharu.activitystreamsserialization.json.impl.KotlinxSerializationConverter
import dev.usbharu.activitystreamsserialization.other.JsonLd
import dev.usbharu.activitystreamsserialization.other.asTypeOfNull
import kotlinx.serialization.json.Json
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

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

inline fun <reified T : JsonLd> checkDeserialize(checkJson: String, type: String): T {
    val t = DefaultObjectFactory.create(preprocess(checkJson)[0]).asTypeOfNull<T>(type)
    assertNotNull(t)
    return t
}