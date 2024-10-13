package netware.client.holders

import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import netware.client.holders.util.Holders
import netware.client.holders.util.formattedResponse

data class RequestError(
    private val statusCode: Int = 0,
    private val status: String = "No status found",
    private val message: String = "No message found."
) {

    fun getStatusCode() = statusCode
    fun getStatus() = status
    fun getMessage() = message

    // Log functions
    fun getLog(isFormatted: Boolean): String {

        var prettyResponse: String

        try {
            val jsonElement = JsonParser.parseString(message)
            val gson = GsonBuilder().setPrettyPrinting().create()
            prettyResponse= gson.toJson(jsonElement).toString()

        } catch (exception: Exception) {
            prettyResponse= message
        }

        return if (isFormatted) {
            formattedResponse(
                statusCode = statusCode,
                status = status,
                message = message,
                holders = Holders.ERROR
            )
        } else {
            """
                Status code: $statusCode, Status: $status.
                Message: $message
                """.trimIndent()
        }
    }

    fun getLog() = """
                Status code: $statusCode, Status: $status.
                Message: $message
                """.trimIndent()
}