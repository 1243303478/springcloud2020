package com.atzy.springcloud.order.controller;

import com.atzy.springcloud.beans.CommonResult;
import com.atzy.springcloud.beans.Payment;
import com.atzy.springcloud.order.myrule.impl.MyLB;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
@Slf4j
public class OrderController {

    @Resource
    RestTemplate restTemplate;

    @Resource
    MyLB myLB;
    @Resource
    DiscoveryClient discoveryClient;

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
    @GetMapping(value = "/consumer/payment/lb")
    public String getPaymentLB() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        ServiceInstance instance = myLB.getInstances(instances);
        URI uri = instance.getUri();
        return restTemplate.getForObject(uri+"payment/lb",String.class);

    }
    @GetMapping("/consumer/payment/zipkin")
    public String paymentZipkin() {
        return restTemplate.getForObject("http://localhost:8001/payment/zipkin",String.class);
    }
}
