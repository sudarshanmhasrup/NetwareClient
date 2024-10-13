package netware.client

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

}