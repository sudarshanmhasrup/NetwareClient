package netware.client.holders

import netware.client.holders.util.Holders
import netware.client.holders.util.formattedResponse

// Data class containing response for every network request
@Suppress("unused")
data class RequestResponse(
    private val statusCode: Int = 0,
    private val status: String = "No status found",
    private val response: String = "No response found",
    private val responseHeaders: Map<String, String> = mutableMapOf("status" to "No headers found")
) {

    fun getStatusCode() = statusCode
    fun getStatus() = status
    fun getResponse() = response
    fun getResponseHeaders() = responseHeaders

    // Log functions
    fun getLog(isFormatted: Boolean): String {
        return if (isFormatted) {
            formattedResponse(
                statusCode = statusCode,
                status = status,
                message = response,
                holders = Holders.RESPONSE
            )
        } else {
            """
                Status code: $statusCode, Status: $status.
                Response: $response
                """.trimIndent()
        }
    }

    fun getLog() = """
                Status code: $statusCode, Status: $status.
                Response: $response
                """.trimIndent()
}