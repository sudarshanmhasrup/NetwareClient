package netware.client

import netware.client.callbacks.ClientCallback
import netware.client.holders.RequestError
import netware.client.holders.RequestResponse

// Main class which is used to send HTTP requests
@Suppress("unused")
class RequestClient(
    url: String
) {

    // Network request properties
    private val networkRequestUrl = url
    private var networkRequestMethod = "GET"
    private val networkRequestHeaders = mutableMapOf<String, String>()
    private var networkRequestBody: String? = null

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
    constructor(url: String, method: String, headers: Map<String, String>, body: String): this(url) {
        networkRequestMethod = method
        addHeaders(headers)
        networkRequestBody = body
    }

    // Secondary constructor 4
    constructor(url: String, headers: Map<String, String>): this(url) {
        networkRequestMethod = "GET"
        addHeaders(headers)
    }

    // Secondary constructor 5
    constructor(url: String, method: String, body: String): this(url) {
        networkRequestMethod = method
        networkRequestBody = body
    }

    // Network request response
    private var response = RequestResponse()
    private var error = RequestError()
    private var isSuccess = false

    private fun isNetworkRequestMethodIsValid(): Boolean {
        return networkRequestMethod in listOf("GET", "POST", "PUT", "PATCH", "DELETE")
    }

    val invalidNetworkRequestLog = RequestError(
        statusCode = 400,
        status = "Bad request",
        message = "\"$networkRequestMethod\" is not a valid HTTP method."
    )

    // Build function: With callback
    fun build(clientCallback: ClientCallback): RequestClient {
        if (!isNetworkRequestMethodIsValid()) {
            isSuccess = false
            clientCallback.onError(
                requestError = RequestError(
                    statusCode = 400,
                    status = "Bad request",
                    message = "\"$networkRequestMethod\" is not a valid HTTP method."
                )
            )
            error = RequestError(
                statusCode = 400,
                status = "Bad request",
                message = "\"$networkRequestMethod\" is not a valid HTTP method."
            )
        } else {

        }
        return this
    }

    // Build function: Without callback
    fun build(): RequestClient {
        if (!isNetworkRequestMethodIsValid()) {
            isSuccess = false
            error = RequestError(
                statusCode = 400,
                status = "Bad request",
                message = "\"$networkRequestMethod\" is not a valid HTTP method."
            )
        } else {

        }
        return this
    }

    fun response() = response
    fun error() = error
    fun isSuccess() = isSuccess

    private fun addHeaders(headers: Map<String, String>) {
        for ((key, value) in headers) {
            networkRequestHeaders[key] = value
        }
    }

    internal fun getNetworkRequestUrl() = networkRequestUrl
    internal fun getNetworkRequestMethod() = networkRequestMethod
    internal fun getNetworkRequestHeaders() = networkRequestHeaders
    internal fun getNetworkRequestBody() = networkRequestBody
    internal fun checkForValidRequestMethod() = isNetworkRequestMethodIsValid()
}