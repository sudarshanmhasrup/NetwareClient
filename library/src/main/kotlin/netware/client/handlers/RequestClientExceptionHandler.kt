package netware.client.handlers

import netware.client.holders.RequestError
import java.lang.Exception

// Function to simplify network request exceptions for RequestClient
fun requestClientExceptionDecoder(exception: Exception): RequestError {
    return RequestError(
        statusCode = 1000,
        status = "Failed",
        message = exception.toString()
    )
}