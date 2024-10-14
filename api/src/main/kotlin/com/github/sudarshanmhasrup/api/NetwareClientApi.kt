package com.github.sudarshanmhasrup.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class NetwareClientApi 

fun main(arguments: Array<String>) {
    runApplication<NetwareClientApi>(*arguments)
}
