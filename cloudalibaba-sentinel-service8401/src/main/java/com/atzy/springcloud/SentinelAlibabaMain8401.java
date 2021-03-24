package com.atzy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SentinelAlibabaMain8401 {
    public static void main(String[] args) {
        SpringApplication.run(SentinelAlibabaMain8401.class,args);
    }
}
