package netware.client.executors

import netware.client.holders.HttpResponseContainer
import netware.client.holders.RequestError
import java.net.HttpURLConnection
import java.net.URI
import javax.net.ssl.HttpsURLConnection

// Class to execute network requests for RequestClient
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
            networkRequestUrl.openConnection() as HttpURLConnection
        } else {
            networkRequestUrl.openConnection() as HttpsURLConnection
        }

        networkRequestConnection.requestMethod = networkRequestMethod

        if (networkRequestHeaders != null) {
            for ((key, value ) in networkRequestHeaders) {
                networkRequestConnection.setRequestProperty(key, value)
            }
        }

        return HttpResponseContainer()
    }
}