package netware.client

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

        val requestBody = """{"message":"Hello World"}"""

        val requestClient = RequestClient(
            url = "http://localhost:3000",
            method = "GET",
            body = requestBody
        )

        assertEquals(requestBody, requestClient.getNetworkRequestBody())
    }

    @Test
    fun testNetworkRequestBodyValidation() {

        val requestClient = RequestClient(
            url = "http://localhost:3000",
            method = "POST"
        )

        assertEquals(true, requestClient.checkForValidRequestMethods())
    }

    @Test
    fun testInvalidNetworkRequestErrorLog() {

        val requestClient = RequestClient(
            url = "http://localhost:3000",
            method = "SET"
        ).build()

    }
}