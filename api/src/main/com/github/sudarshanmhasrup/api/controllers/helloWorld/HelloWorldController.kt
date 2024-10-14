package com.github.sudarshanmhasrup.api.controllers.helloWorld

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloWorldController {

    @GetMapping("/v1/hello-world")
    fun getHelloWorld(): HelloWorldControllerResponse {
        return HelloWorldControllerResponse(
            statusCode = 200,
            message = "Hello World!"
        )
    }
}