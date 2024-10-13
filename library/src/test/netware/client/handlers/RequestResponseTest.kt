package netware.client.handlers

import netware.client.holders.RequestResponse
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RequestResponseTest {

    @Test
    fun testUnformattedLog() {

        val requestResponse = RequestResponse(
            statusCode = 200,
            status = "OK",
            response = """
                {"message":"Hello World"
                """.trimIndent()
        )

        assertEquals("""
            Status code: 200, Status: OK.
            Response: {"message":"Hello World"
        """.trimIndent(), requestResponse.getLog())
    }
}