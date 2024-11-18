package org.example.demo.persistence.po

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import com.fasterxml.jackson.annotation.JsonFormat
import org.springframework.format.annotation.DateTimeFormat
import java.util.Date

@TableName("t_ms_applian")
class Appliance {
    @TableId(value = "id", type = IdType.AUTO)
    var id: Long? = null

    /** 家电SN  */
    var sn: String? = null

    var tsn: String? = null

    /** 家电设备ID  */
    @TableField("appliance_code")
    var applianceCode: Long? = null

    /** 家电类型(表T_IHAP_APPLIAN_TYPE的TYPE字段作为外键)  */
    @TableField("appliance_type")
    var applianceType: String? = null

    /** 激活状态(0：未激活，1：已激活)  */
    @TableField("active_status")
    var activeStatus: Int? = null

    /** 家电名  */
    var name: String? = null

    /** 家电描述  */
    var des: String? = null

    /** 激活时间  */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("active_time")
    var activeTime: Date? = null

    /** 家电SN对应的PID  */
    @TableField("org_pid")
    var orgPid: String? = null

    /** 家电企业码  */
    var enterprise: String? = null

    @TableField("model_number")
    var modelNumber: String? = null

    /** 模块类型(2G,wifi模块等)  */
    @TableField("module_type")
    var moduleType: String? = null

    @TableField("appliance_version")
    var applianceVersion: String? = null

    /** 家电对应WIFI版本号信息  */
    @TableField("wifi_version")
    var wifiVersion: String? = null

    @TableField("register_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    var registerTime: Date? = null

    /** 设备关联id，可以是主设备，也可以是其他关联设备的id等  */
    @TableField("relation_id")
    var relationId: String? = null

    var mac: String? = null

}