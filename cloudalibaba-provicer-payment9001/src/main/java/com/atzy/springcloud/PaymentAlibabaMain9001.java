package com.atzy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PaymentAlibabaMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentAlibabaMain9001.class,args);
    }
}
