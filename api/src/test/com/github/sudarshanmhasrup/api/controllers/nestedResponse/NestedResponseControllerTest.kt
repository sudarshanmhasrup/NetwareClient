package com.github.sudarshanmhasrup.api.controllers.nestedResponse

import netware.client.RequestClient
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NestedResponseControllerTest {

    @Test
    fun testNestedResponseController() {

        val requestClient = RequestClient(
            url = "http://localhost:8000/v1/get-nested-response",
            method = "GET"
        ).build()

        val expectedResult = Response(
            statusCode = 200,
            message = Message(
                message = "Hello World!",
                from = "John doe."
            )
        )

        val actualResult = requestClient.response().getResponse<Response>()
        assertEquals(expectedResult, actualResult)
    }
}