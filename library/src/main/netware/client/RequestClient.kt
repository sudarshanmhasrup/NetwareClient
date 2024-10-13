package netware.client

import com.google.gson.JsonObject
import netware.client.callbacks.ClientCallback
import netware.client.holders.RequestError
import netware.client.holders.RequestResponse

@Suppress("unused")
class RequestClient(
    url: String
) {

    // Network request properties
    private val networkRequestUrl = url
    private var networkRequestMethod = "GET"
    private val networkRequestHeaders = mutableMapOf<String, String>()
    private var networkRequestBody: JsonObject? = null

    // Secondary constructor 1
    constructor(url: String, method: String): this(url) {
        networkRequestMethod = method
    }

    // Secondary constructor 2
    constructor(url: String, method: String, headers: Map<String, String>): this(url) {
        networkRequestMethod = method
        addHeaders(headers)
    }

    // Secondary constructor 3
    constructor(url: String, method: String, headers: Map<String, String>, body: JsonObject): this(url) {
        networkRequestMethod = method
        addHeaders(headers)
        networkRequestBody = body
    }

    // Secondary constructor 4
    constructor(url: String, headers: Map<String, String>): this(url) {
        networkRequestMethod = "GET"
        addHeaders(headers)
    }

    // Secondary constructor 4
    constructor(url: String, method: String, body: JsonObject): this(url) {
        networkRequestMethod = method
        networkRequestBody = body
    }

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

    private fun addHeaders(headers: Map<String, String>) {
        for ((key, value) in headers) {
            networkRequestHeaders[key] = value
        }
    }

    internal fun getNetworkRequestUrl() = networkRequestUrl
    internal fun getNetworkRequestMethod() = networkRequestMethod
    internal fun getNetworkRequestHeaders() = networkRequestHeaders
    internal fun getNetworkRequestBody() = networkRequestBody
}