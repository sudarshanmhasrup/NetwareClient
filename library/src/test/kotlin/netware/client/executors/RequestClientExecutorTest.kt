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

        val requestClientExecutor = RequestClientExecutor(
            networkRequestUrl = "http://localhost:8000/v1/hello-world",
            networkRequestMethod = "GET"
        ).executeNetworkRequest(isHTTPs = false)

        assertEquals("""
            Status code: 200, Status: No status found.
            Response: {"statusCode":200,"message":"Hello World!"}
        """.trimIndent(), requestClientExecutor.getRequestResponse().getLog())
    }
}