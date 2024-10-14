package netware.client.executors

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RequestClientExecutorTest {

    @Test
    fun testInvalidRequestProtocolLog() {

        val requestClientExecutor = RequestClientExecutor(
            networkRequestUrl = "postgresql://localhost:3000",
            networkRequestMethod = "GET"
        )

        assertEquals("""
            Status code: 400, Status: Bad request.
            Message: The request protocol is invalid.
        """.trimIndent(), requestClientExecutor.validateNetworkRequest().getRequestError().getLog())
    }

    @Test
    fun testExecuteNetworkRequestFunction() {

    }
}