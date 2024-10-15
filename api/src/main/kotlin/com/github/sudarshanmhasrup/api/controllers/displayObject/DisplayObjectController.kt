package com.github.sudarshanmhasrup.api.controllers.displayObject

import com.github.sudarshanmhasrup.api.controllers.displayObject.dataClass.CustomObject
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class DisplayObjectController {

    @PostMapping("/v1/display-custom-object")
    fun displayObject(@RequestBody customObject: CustomObject): CustomObject {
        return customObject
    }
}