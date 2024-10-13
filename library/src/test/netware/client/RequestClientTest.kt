package netware.client

import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RequestClientTest {

    @Test
    fun testUrlInitialization() {

        val requestClient = RequestClient(
            url = "http://localhost:3000"
        )

        assertEquals("http://localhost:3000", requestClient.getNetworkRequestUrl())
    }

    @Test
    fun testMethodInitialization() {

        val requestClient = RequestClient(
            url = "http://localhost:3000",
            method = "GET"
        )

        assertEquals("GET", requestClient.getNetworkRequestMethod())
    }

    @Test
    fun testHeadersInitialization() {

        val headers = mapOf(
            "value" to "something",
            "something" to "value"
        )

        val request = RequestClient(
            url = "http://localhost:3000",
            method = "GET",
            headers = headers
        )

        assertEquals(headers, request.getNetworkRequestHeaders())
    }

    @Test
    fun testBodyInitialization() {

        val requestBody = JsonParser.parseString("""{"message":"Hello World"}""")

        val requestClient = RequestClient(
            url = "http://localhost:3000",
            method = "GET",
            body = JsonObject()
        )

        assertEquals(requestBody, requestClient.getNetworkRequestBody())
    }
}