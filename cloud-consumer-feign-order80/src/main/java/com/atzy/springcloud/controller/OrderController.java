package com.atzy.springcloud.controller;

import com.atzy.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {
    @Resource
    PaymentFeignService paymentFeignService;


    @GetMapping(value = "/consumer/payment/lb")
    public String getPaymentLB(){
        return paymentFeignService.getPaymentLB();
    }

    @GetMapping(value = "/consumer/payment/timeout")
    public String getPaymentTimeout() {
        return paymentFeignService.getPaymentTimeout();
    }
}
