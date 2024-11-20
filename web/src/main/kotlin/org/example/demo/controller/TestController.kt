package org.example.demo.controller

import org.example.demo.persistence.po.Appliance
import org.example.demo.persistence.service.ApplianceService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.Executors


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

    @GetMapping("/test")
    fun test(): String {
        logger.info("test---start..")
        val sleep1 = sleep1()
        val sleep2 = sleep2()
        val sleep3 = sleep3()
        logger.info("test---join start..")
        sleep1.join()
        logger.info("test---join1..")
        sleep2.join()
        logger.info("test---join2..")
        sleep3.join()
        logger.info("test---join3..")
        logger.info("test---end..")
        return """
            {
            "success":true
            }
        """.trimIndent();
    }

    fun sleep1(): Thread {
        Executors.newVirtualThreadPerTaskExecutor().submit{

        }
        return Thread.startVirtualThread {
            logger.info("sleep1---start..")
            Thread.sleep(400)
            logger.info("sleep1---end..")
        }
    }

    fun sleep2(): Thread {
        return Thread.startVirtualThread {
            logger.info("sleep2---start..")
            Thread.sleep(400)
            logger.info("sleep2---end..")
        }
    }

    fun sleep3(): Thread {
        return Thread.startVirtualThread {
            logger.info("sleep3---start..")
            Thread.sleep(400)
            logger.info("sleep3---end..")
        }
    }
}