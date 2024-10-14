package com.github.sudarshanmhasrup.api.controllers.customGreetings

import kotlinx.serialization.Serializable

@Serializable
data class CustomGreetingsResponse(
    val statusCode: Int,
    val message: String
)