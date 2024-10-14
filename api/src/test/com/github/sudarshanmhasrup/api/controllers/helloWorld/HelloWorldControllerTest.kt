package com.github.sudarshanmhasrup.api.controllers.helloWorld

import netware.client.RequestClient
import org.junit.jupiter.api.Test

class HelloWorldControllerTest {

    @Test
    fun testHelloWorldEndpoint() {

        val requestClient = RequestClient(
            url = "http://localhost:8000/v1/hello-world",
            method = "GET"
        ).build()

    }
}