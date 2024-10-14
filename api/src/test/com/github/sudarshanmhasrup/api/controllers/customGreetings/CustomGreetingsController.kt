package com.github.sudarshanmhasrup.api.controllers.customGreetings

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class CustomGreetingsController {

    @PostMapping("/v1/display-message")
    fun displayMessage(@RequestBody message: String): CustomGreetingsResponse {
        return CustomGreetingsResponse(
            statusCode = 200,
            message = message
        )
    }
}