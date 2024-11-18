package org.example.demo.controller

import org.example.demo.persistence.po.Appliance
import org.example.demo.persistence.service.ApplianceService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController {
    private val logger: Logger = LoggerFactory.getLogger(TestController::class.java)

    @Autowired
    private var applianceService: ApplianceService? = null

    @GetMapping("/hello")
    fun index(@RequestParam("name") name: String): String {
        logger.info("Hello, $name!")
        return "Hello, $name!"
    }

    @GetMapping("/select")
    fun select(): MutableList<Appliance>? {
        return applianceService?.list();
    }
}