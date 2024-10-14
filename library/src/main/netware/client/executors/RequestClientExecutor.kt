package netware.client.executors

import netware.client.holders.HttpResponseContainer
import netware.client.holders.RequestError

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
                executeRequestUrl(isHttp = false)
            }
            networkRequestUrl.startsWith("https://") -> {
                executeRequestUrl(isHttp = true)
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

    internal fun executeRequestUrl(isHttp: Boolean): HttpResponseContainer {
        return HttpResponseContainer()
    }
}