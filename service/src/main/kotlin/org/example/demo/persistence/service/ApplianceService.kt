package org.example.demo.persistence.service

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import org.example.demo.persistence.mapper.ApplianceMapper
import org.example.demo.persistence.po.Appliance
import org.springframework.stereotype.Service

@Service
open class ApplianceService : ServiceImpl<ApplianceMapper, Appliance>()