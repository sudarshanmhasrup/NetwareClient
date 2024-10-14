package com.github.sudarshanmhasrup.api.controllers.authentication

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class AuthenticationController {

    @PostMapping("/v1/auth/create-new-account")
    fun createNewAccount() {

    }
}