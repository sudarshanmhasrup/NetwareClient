package netware.client

import netware.client.callbacks.ClientCallback
import netware.client.holders.RequestError
import netware.client.holders.RequestResponse

@Suppress("unused")
class RequestClient(
    url: String
) {

    // Network request properties
    private val networkRequestUrl = url
    private val networkRequestMethod = "GET"
    private val networkRequestHeaders = mutableMapOf<String, String>()
    private val networkRequestBody: String? = null

    // Network request response
    var response = RequestResponse()
    var error = RequestError()
    var isSuccess = false

    // Build function: With callback
    fun build(clientCallback: ClientCallback): RequestClient {
        return this
    }

    // Build function: Without callback
    fun build(): RequestClient {
        return this
    }
}