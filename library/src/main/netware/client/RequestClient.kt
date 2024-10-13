package netware.client

class RequestClient(
    private val url: String
) {

    // Network request properties
    private val networkRequestUrl = url
    private val networkRequestMethod = "GET"
    private val networkRequestHeaders = mutableMapOf<String, String>()
    private val networkRequestBody: String? = null

    // Network request response

}