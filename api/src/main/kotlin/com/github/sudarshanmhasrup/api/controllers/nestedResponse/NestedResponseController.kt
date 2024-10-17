package com.github.sudarshanmhasrup.api.controllers.nestedResponse

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class NestedResponseController {

    @GetMapping("/v1//v1/get-nested-response")
    fun methodFunction(): Response {
        return Response(
            statusCode = 200,
            message = Message(
                message = "Hello World!",
                from = "John doe."
            )
        )
    }
}