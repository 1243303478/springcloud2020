package com.atzy.springcloud.config;

import feign.Feign;
import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {
    /**
     * 配置feign输出日志的输出规则
     * @return
     */
    @Bean
    Logger.Level feignLoggerLever(){
        return Logger.Level.FULL;
    }
}
