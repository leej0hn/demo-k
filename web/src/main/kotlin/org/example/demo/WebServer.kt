package org.example.demo

import org.mybatis.spring.annotation.MapperScan
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class WebServer : CommandLineRunner {
    private val logger: Logger = LoggerFactory.getLogger(WebServer::class.java)

    @Value("\${spring.application.name}")
    private val appName: String? = null

    override fun run(vararg args: String?) {
        logger.info("{} 启动成功", this.appName)
    }
}

fun main(args: Array<String>) {
    runApplication<WebServer>(*args)
}