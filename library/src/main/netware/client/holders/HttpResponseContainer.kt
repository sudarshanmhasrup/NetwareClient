package netware.client.holders

// This class contains server response and error of network requests being sent using RequestClientExecutor
data class HttpResponseContainer(
    private val isSuccess: Boolean = false,
    private val requestResponse: RequestResponse = RequestResponse(),
    private val requestError: RequestError = RequestError()
) {

    fun isSuccess() = isSuccess
    fun getRequestResponse() = requestResponse
    fun getRequestError() = requestError
}