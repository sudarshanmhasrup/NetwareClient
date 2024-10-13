package netware.client.handlers

import netware.client.holders.RequestError
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RequestErrorTests {

    @Test
    fun testUnformattedLog() {

        val requestError = RequestError(
            statusCode = 400,
            status = "Unauthorized",
            message = """
                {"message":"Access denied"}
            """.trimIndent()
        )

        assertEquals("""
            Status code: 400, Status: Unauthorized.
            Message: {"message":"Access denied"}
        """.trimIndent(), requestError.getLog())

    }
}