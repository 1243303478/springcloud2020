package com.atzy.springcloud.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Payment8002MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(Payment8002MainApplication.class,args);
    }
}
