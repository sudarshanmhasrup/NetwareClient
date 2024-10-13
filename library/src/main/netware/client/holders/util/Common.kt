package netware.client.holders.util

import com.google.gson.GsonBuilder
import com.google.gson.JsonParser

// Top level function to return well formatted response and error
internal fun formattedResponse(
    statusCode: Int,
    status: String,
    message: String,
    holders: Holders
): String {

    var prettyResponse: String

    try {
        val jsonElement = JsonParser.parseString(message)
        val gson = GsonBuilder().setPrettyPrinting().create()
        prettyResponse = gson.toJson(jsonElement).toString()

    } catch (exception: Exception) {
        prettyResponse = message
    }

    return if (holders == Holders.RESPONSE) {
        """
                ----------------------------------------------------------------------
                Status code: $statusCode, Status: $status.
                Response: ------------------------------------------------------------
                
            """.trimIndent() +
                prettyResponse + """

                ----------------------------------------------------------------------
""".trimIndent()
    } else {
        """
                ----------------------------------------------------------------------
                Status code: $statusCode, Status: $status.
                Message: -------------------------------------------------------------
                
            """.trimIndent() +
                prettyResponse + """

                ----------------------------------------------------------------------
""".trimIndent()
    }
}