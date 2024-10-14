package com.github.sudarshanmhasrup.api.controllers.customGreetings

import netware.client.RequestClient
import netware.client.extensions.RequestHeaders
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CustomGreetingsControllerTest {

    @Test
    fun testCustomGreetingsController() {

        val requestHeaders = RequestHeaders()
        requestHeaders.add("Content-Type", "text/plain")

        val requestClient = RequestClient(
            url = "http://localhost:8000/v1/display-custom-message",
            method = "POST",
            headers = requestHeaders.getHeaders(),
            body = "Hello World"
        ).build()

        assertEquals("""
            Status code: 200, Status: No status found.
            Response: {"statusCode":200,"message":"Hello World"}
        """.trimIndent(), requestClient.response().getLog())
    }
}