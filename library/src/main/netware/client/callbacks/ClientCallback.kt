package netware.client.callbacks

import netware.client.holders.RequestError
import netware.client.holders.RequestResponse

@Suppress("unused")
interface ClientCallback {

    fun onSuccess(requestResponse: RequestResponse) {
        println(requestResponse.getLog(
            isFormatted = true
        ))
    }
    fun onError(requestError: RequestError) {
        println(requestError.getLog(
            isFormatted = true
        ))
    }
}