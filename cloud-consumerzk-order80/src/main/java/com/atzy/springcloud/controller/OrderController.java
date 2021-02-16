package com.atzy.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderController {

    public static final String payment_url = "http://cloud-provider-payment8004/";

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/consumer/payment/zk")
    public String paymentZk(){
        return restTemplate.getForObject(payment_url+"payment/zk",String.class);
    }
}
