package com.atzy.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigController {
    @Value("${config.info}")
    private String info;

    @GetMapping("get/config/info")
    public String getInfo(){
        System.out.println("获取到的系统信息是:"+info);
        return info;
    }
}
