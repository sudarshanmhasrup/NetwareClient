package netware.client.extentions

import netware.client.extensions.jsonSerializer
import netware.client.extentions.dataClass.Response
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class JsonSerializerTest {

    @Test
    fun testJsonSerializer() {

        val expectedResult = """
            {"statusCode":200,"message":"Hello World"}
        """.trimIndent()

        val response = Response(
            statusCode = 200,
            message = "Hello World"
        )

        val actualResult = jsonSerializer(response)

        assertEquals(expectedResult, actualResult)
    }
}