package com.github.sudarshanmhasrup.api.controllers.helloWorld

import netware.client.RequestClient
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class HelloWorldControllerTest {

    @Test
    fun testHelloWorldEndpoint() {

        val requestClient = RequestClient(
            url = "http://localhost:8000/v1/hello-world",
            method = "GET"
        ).build()

        assertEquals("""
            Status code: 200, Status: No status found.
            Response: {"statusCode":200,"message":"Hello World!"}
        """.trimIndent(), requestClient.response().getLog())
    }
}