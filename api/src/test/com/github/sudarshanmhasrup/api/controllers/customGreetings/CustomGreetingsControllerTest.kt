package com.github.sudarshanmhasrup.api.controllers.customGreetings

import netware.client.RequestClient
import org.junit.jupiter.api.Test

class CustomGreetingsControllerTest {

    @Test
    fun testCustomGreetingsController() {

        val requestClient = RequestClient(
            url = "http://localhost:8000/v1/display-custom-message",
            method = "POST",
            body = """
                {"message":"Hello, I'm Sudarshan!"
            """.trimIndent()
        ).build()

        println(requestClient.response().getLog(
            isFormatted = true
        ))
    }
}