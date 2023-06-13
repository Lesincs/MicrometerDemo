package com.example.demo.hello

import jakarta.servlet.http.HttpServletRequest
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {
    private val logger: Logger = LoggerFactory.getLogger(HelloController::class.java)

    @Autowired
    private lateinit var httpRequest: HttpServletRequest

    @GetMapping("/helloworld")
    fun helloWorld(): String {
        logger.info("Received request for /hello")
        logger.info("http headers:${httpRequest.headerNames.toList()}")
        for (headerName in httpRequest.headerNames) {
            if (headerName == "x-b3-traceid" || headerName == "x-b3-spanid" || headerName == "b3") {
                logger.info("http header: " + headerName + ":" + httpRequest.getHeader(headerName))
            }
        }
        return "helloworld"
    }
}
