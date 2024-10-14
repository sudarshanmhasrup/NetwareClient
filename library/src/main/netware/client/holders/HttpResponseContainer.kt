package netware.client.holders

data class HttpResponseContainer(
    private val isSuccess: Boolean = false,
    private val requestResponse: RequestResponse = RequestResponse(),
    private val requestError: RequestError = RequestError()
) {

    fun isSuccess() = isSuccess
    fun getRequestResponse() = requestResponse
    fun getRequestError() = requestError
}