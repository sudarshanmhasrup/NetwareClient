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
            response = "Hey"
        )

        assertEquals("""
            Status code: 200, Status: OK.
            Response: Hey
        """.trimIndent(), requestResponse.getLog())
    }
}