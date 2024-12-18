package netware.client

import netware.client.callbacks.ClientCallback
import netware.client.executors.RequestClientExecutor
import netware.client.holders.RequestError
import netware.client.holders.RequestResponse

/*
    This class is responsible for building and executing network requests. This class utilizes multiple secondary
parameters, enabling the user to bypass unnecessary parameter lists when using it in Java.

    It supports the following HTTP requests:
    1) GET.
    2) POST.
    3) PATCH.
    4) DELETE.
    5) PUT.

    This class lets library users to handle the network requests using callback and without callback build functions.
Also, this class uses the RequestClientExecutor class behind the scenes to execute network requests.
 */
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
    constructor(url: String, method: String) : this(url) {
        networkRequestMethod = method
    }

    // Secondary constructor 2
    constructor(url: String, method: String, headers: Map<String, String>) : this(url) {
        networkRequestMethod = method
        addHeaders(headers)
    }

    // Secondary constructor 3
    constructor(url: String, method: String, headers: Map<String, String>, body: String) : this(url) {
        networkRequestMethod = method
        addHeaders(headers)
        networkRequestBody = body
    }

    // Secondary constructor 4
    constructor(url: String, headers: Map<String, String>) : this(url) {
        networkRequestMethod = "GET"
        addHeaders(headers)
    }

    fun method(method: String): RequestClient {
        networkRequestMethod = method
        return this
    }

    fun headers(headers: Map<String, String>): RequestClient {
        addHeaders(headers)
        return this
    }

    fun body(body: String): RequestClient {
        networkRequestBody = body
        return this
    }

    // Secondary constructor 5
    constructor(url: String, method: String, body: String) : this(url) {
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

    // Build function: With callback
    fun build(clientCallback: ClientCallback): RequestClient {
        executor(object: ClientCallback {
            override fun onSuccess(requestResponse: RequestResponse) {
                clientCallback.onSuccess(
                    requestResponse = requestResponse
                )
            }

            override fun onError(requestError: RequestError) {
                clientCallback.onError(
                    requestError = requestError
                )
            }
        })
        return this
    }

    // Build function: Without callback
    fun build(): RequestClient {
        executor(object: ClientCallback {
            override fun onSuccess(requestResponse: RequestResponse) {
                isSuccess = true
            }

            override fun onError(requestError: RequestError) {
                isSuccess = false
            }
        })
        return this
    }

    private fun getInvalidNetworkRequestError() = RequestError(
        statusCode = 400,
        status = "Bad request",
        message = "\"$networkRequestMethod\" is not a valid HTTP method."
    )

    private fun executor(clientCallback: ClientCallback) {

        if (!isNetworkRequestMethodIsValid()) {
            isSuccess = false
            error = getInvalidNetworkRequestError()
            clientCallback.onError(
                requestError = getInvalidNetworkRequestError()
            )
        } else {
            val requestClientExecutor = RequestClientExecutor(
                networkRequestUrl = networkRequestUrl,
                networkRequestMethod = networkRequestMethod,
                networkRequestHeaders = networkRequestHeaders,
                networkRequestBody = networkRequestBody
            ).validateNetworkRequest()

            if (requestClientExecutor.isSuccess()) {
                isSuccess = true
                response = requestClientExecutor.getRequestResponse()
                clientCallback.onSuccess(
                    requestResponse = requestClientExecutor.getRequestResponse()
                )
            } else {
                isSuccess = false
                error = requestClientExecutor.getRequestError()
                clientCallback.onError(
                    requestError = requestClientExecutor.getRequestError()
                )
            }
        }
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