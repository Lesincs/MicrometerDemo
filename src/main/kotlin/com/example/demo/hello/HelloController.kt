package com.example.demo.hello

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {
    private val logger = LoggerFactory.getLogger(HelloController::class.java)

    @GetMapping("/hello")
    fun hello(): String {
        logger.info("Received request for /hello")
        return "helloworld"
    }
}