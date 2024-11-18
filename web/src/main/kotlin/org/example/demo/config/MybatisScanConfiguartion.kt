package org.example.demo.config

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Configuration

@Configuration
@EnableAutoConfiguration
@MapperScan("org.example.demo.persistence.mapper")
open class MybatisScanConfiguartion