package netware.client.executors

import netware.client.handlers.requestClientExceptionDecoder
import netware.client.holders.HttpResponseContainer
import netware.client.holders.RequestError
import netware.client.holders.RequestResponse
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URI
import javax.net.ssl.HttpsURLConnection

// Class to execute network requests for RequestClient
@Suppress("unused")
internal class RequestClientExecutor(
    private val networkRequestUrl: String,
    private val networkRequestMethod: String,
    private val networkRequestHeaders: Map<String, String>? = null,
    private val networkRequestBody: String? = null
) {

    internal fun validateNetworkRequest(): HttpResponseContainer {
        return when {
            networkRequestUrl.startsWith("http://") -> {
                executeNetworkRequest(isHTTPs = false)
            }

            networkRequestUrl.startsWith("https://") -> {
                executeNetworkRequest(isHTTPs = true)
            }

            else ->
                HttpResponseContainer(
                    isSuccess = false,
                    requestError = RequestError(
                        statusCode = 400,
                        status = "Bad request",
                        message = "The request protocol is invalid."
                    )
                )
        }
    }

    internal fun executeNetworkRequest(isHTTPs: Boolean): HttpResponseContainer {

        val networkRequestUri = URI(networkRequestUrl)
        val networkRequestUrl = networkRequestUri.toURL()

        val networkRequestConnection = if (isHTTPs) {
            networkRequestUrl.openConnection() as HttpsURLConnection
        } else {
            networkRequestUrl.openConnection() as HttpURLConnection
        }

        networkRequestConnection.requestMethod = networkRequestMethod

        if (networkRequestHeaders != null) {
            for ((key, value) in networkRequestHeaders) {
                networkRequestConnection.setRequestProperty(key, value)
            }
        }

        if (networkRequestBody != null) {
            networkRequestConnection.doInput = true
            networkRequestConnection.doOutput = true
            OutputStreamWriter(networkRequestConnection.outputStream).use { writer ->
                writer.write(networkRequestBody)
                writer.flush()
            }
        }

        try {

            val serverResponseStatusCode = networkRequestConnection.responseCode
            val serverResponseStatus = networkRequestConnection.responseMessage ?: "No status found"

            val serverResponse = if (serverResponseStatusCode in 200..299) {
                networkRequestConnection.inputStream.bufferedReader().use {
                    it.readText()
                }
            } else {
                networkRequestConnection.errorStream.bufferedReader().use {
                    it.readText()
                }
            }

            val responseHeaders: MutableMap<String, String> = mutableMapOf()

            // Read response map
            networkRequestConnection.headerFields.forEach {
                responseHeaders[it.key] = it.value.toString()
            }

            networkRequestConnection.disconnect()
            return HttpResponseContainer(
                isSuccess = true,
                requestResponse = RequestResponse(
                    statusCode = serverResponseStatusCode,
                    status = serverResponseStatus,
                    response = serverResponse,
                    responseHeaders = responseHeaders
                )
            )
        } catch (exception: Exception) {
            return HttpResponseContainer(
                isSuccess = false,
                requestError = requestClientExceptionDecoder(exception)
            )
        }
    }
}