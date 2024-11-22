package org.example.demo.controller

import org.example.demo.persistence.po.Appliance
import org.example.demo.persistence.service.ApplianceService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit


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

    @GetMapping("/test/join")
    fun testJoin(): String {
        logger.info("test---start..${Thread.currentThread()}")
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

    @GetMapping("/test/feature")
    fun testFeature(): String {
        logger.info("test---start..${Thread.currentThread()}")
        val f1 = sleepFeature1()
        val f2 = sleepFeature2()
        val f3 = sleepFeature3()
        val allOf = CompletableFuture.allOf(f1, f2, f3)
        // 等待所有任务完成
        allOf[4, TimeUnit.SECONDS]
        logger.info("test---end..")
        return """
            {
            "success":true
            }
        """.trimIndent();
    }

    fun sleepFeature1(): CompletableFuture<Void> {
        return CompletableFuture.runAsync({
            logger.info("sleepFeature1---start..${Thread.currentThread()}")
            Thread.sleep(400)
            logger.info("sleepFeature1---end..")
            logger.info("${Thread.currentThread()}---end..")
        }, Executors.newVirtualThreadPerTaskExecutor())
    }

    fun sleepFeature2(): CompletableFuture<Void> {
        return CompletableFuture.runAsync({
            logger.info("sleepFeature2---start..${Thread.currentThread()}")
            Thread.sleep(400)
            logger.info("sleepFeature2---end..")
        }, Executors.newVirtualThreadPerTaskExecutor())
    }

    fun sleepFeature3(): CompletableFuture<Void> {
        return CompletableFuture.runAsync({
            logger.info("sleepFeature3---start..${Thread.currentThread()}")
            Thread.sleep(2000)
            logger.info("sleepFeature3---end..")
        }, Executors.newVirtualThreadPerTaskExecutor())
    }

    fun sleep1(): Thread {
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