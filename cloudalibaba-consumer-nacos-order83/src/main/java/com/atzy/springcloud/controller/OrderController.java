package com.atzy.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class OrderController {

    @Value("${service-url.nacos-user-service}")
    private String service_url;
    @Resource
    RestTemplate restTemplate;

    @GetMapping("/consumer/payment/lb")
    public String paymentInfo(){
        return restTemplate.getForObject(service_url+"/payment/ali/lb",String.class);
    }
}
