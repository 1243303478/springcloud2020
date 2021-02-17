package com.atzy.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderController {
    @Autowired
    RestTemplate restTemplate;

    public static final String PAYMENT_URL = "http://cloud-providerconsul-payment8006/";

    @GetMapping("/consumer/payment/consul")
    public String PaymentConsul(){
        return restTemplate.getForObject(PAYMENT_URL+"payment/consul",String.class);
    }
}
