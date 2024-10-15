package com.github.sudarshanmhasrup.api.controllers.displayObject

import com.github.sudarshanmhasrup.api.controllers.displayObject.dataClass.CustomObject
import netware.client.RequestClient
import netware.client.extensions.RequestHeaders
import netware.client.extensions.jsonSerializer
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DisplayObjectControllerTest {

    @Test
    fun testDisplayObjectController() {

        val customObject = CustomObject(
            firstName = "John",
            lastName = "Doe"
        )

        val requestHeaders = RequestHeaders()
        requestHeaders.add("Content-Type", "application/json")
        requestHeaders.add("Accept", "application/json")

        val requestClient = RequestClient(
            url = "http://localhost:8000/v1/display-custom-object",
            method = "POST",
            headers = requestHeaders.getHeaders(),
            body = jsonSerializer(customObject)
        ).build()

        assertEquals("""
            Status code: 200, Status: No status found.
            Response: {"firstName":"John","lastName":"Doe"}
        """.trimIndent(), requestClient.response().getLog())
    }
}