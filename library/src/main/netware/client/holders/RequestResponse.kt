package netware.client.holders

import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import netware.client.holders.util.Holders
import netware.client.holders.util.formattedResponse

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

        var prettyResponse: String

        try {
            val jsonElement = JsonParser.parseString(response)
            val gson = GsonBuilder().setPrettyPrinting().create()
            prettyResponse= gson.toJson(jsonElement).toString()

        } catch (exception: Exception) {
            prettyResponse= response
        }

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