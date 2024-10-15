package com.github.sudarshanmhasrup.api.controllers.displayObject

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@SpringBootApplication
class DisplayObjectController {

    @PostMapping("/v1/display-custom-object")
    fun displayObject(@RequestBody requestBody: RequestBody): RequestBody {
        return requestBody
    }
}