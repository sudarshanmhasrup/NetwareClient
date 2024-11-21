package netware.client.callbacks

import netware.client.holders.RequestError
import netware.client.holders.RequestResponse

// This interface is supposed to be implemented by the library user for build() function with callback
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