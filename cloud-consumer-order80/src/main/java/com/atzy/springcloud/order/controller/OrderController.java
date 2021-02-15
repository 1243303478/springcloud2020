package com.atzy.springcloud.order.controller;

import com.atzy.springcloud.beans.CommonResult;
import com.atzy.springcloud.beans.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {

    @Resource
    RestTemplate restTemplate;

    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE/"; //使用eureka中注册的服务名

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") long id){
        //远程调用controller
        return restTemplate.getForObject(PAYMENT_URL+"get/"+id,CommonResult.class);
    }

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create( Payment payment){
        //远程调用controller
        return restTemplate.postForObject(PAYMENT_URL+"create",payment,CommonResult.class);
    }
}
