package com.github.sudarshanmhasrup.api.controllers.nestedResponse

data class Response(
    val statusCode: Int,
    val message: Message
)

data class Message(
    val message: String,
    val from: String
)