import netware.client.RequestClient
import netware.client.extensions.RequestHeaders
import netware.client.extensions.Serializer

class RequestExecutor {

    fun execute() {

        val requestHeaders = RequestHeaders()
            .add("Content-Type", "application/json")

        val requestBody = RequestBody(
            firstName = "John",
            lastName = "Doe"
        )

        val requestClient = RequestClient(
            url = "http://localhost:8000/v1/display-custom-object",
            method = "POST",
            headers = requestHeaders.getHeaders(),
            body = Serializer.serialize(requestBody)
        ).build()

        if (requestClient.isSuccess()) {
            println(requestClient.response().getLog(
                isFormatted = true
            ))
        } else {
            println(requestClient.error().getLog(
                isFormatted = true
            ))
        }
    }
}