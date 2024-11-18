package org.example.demo.persistence

import com.baomidou.mybatisplus.core.conditions.Wrapper
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import org.example.demo.BaseTest
import org.example.demo.persistence.mapper.ApplianceMapper
import org.example.demo.persistence.po.Appliance
import org.junit.jupiter.api.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired

class ApplianceMapperTest : BaseTest() {
    private val logger: Logger = LoggerFactory.getLogger(ApplianceMapperTest::class.java)

    @Autowired
    private val mapper: ApplianceMapper? = null

    @Test
    fun testSelect() {
        logger.info("testing...")
        val wrapper: Wrapper<Appliance> = QueryWrapper()
        val list: MutableList<Appliance>? = mapper?.selectList(wrapper)
        logger.info("size: ${list?.size}")
    }
}