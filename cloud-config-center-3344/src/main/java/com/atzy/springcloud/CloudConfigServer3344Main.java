package com.atzy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class CloudConfigServer3344Main {
    public static void main(String[] args) {
        SpringApplication.run(CloudConfigServer3344Main.class,args);
    }
}
