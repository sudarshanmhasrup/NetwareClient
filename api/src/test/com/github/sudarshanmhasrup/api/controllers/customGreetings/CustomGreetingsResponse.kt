package com.github.sudarshanmhasrup.api.controllers.customGreetings

@Serializable
data class CustomGreetingsResponse(
    val statusCode: Int,
    val message: String
)