package com.atzy.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String server_port;

    @GetMapping("payment/consul")
    public String paymentZk(){
        return "SpringCloud with consul:" + server_port + "\t" + UUID.randomUUID().toString();
    }
}
