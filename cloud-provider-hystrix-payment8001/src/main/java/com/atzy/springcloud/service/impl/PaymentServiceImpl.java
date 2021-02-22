package com.atzy.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.atzy.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + " paymentInfo_OK,id:" + id + "\t" + "O(∩_∩)O哈哈~";
    }


    @Override
    public String paymentInfo_TimeOut(Integer id) {
        int timeNumber = 5;
        /*int a = 10/0;*/
        try {
            // 暂停3秒钟
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "线程池:" + Thread.currentThread().getName() + " paymentInfo_TimeOut,id:" + id + "\t" +
                "O(∩_∩)O哈哈~  耗时(秒)" + timeNumber;
    }

    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//多少次请求
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//在多少秒内
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),//失败率
    })
    @Override
    public String paymentCircuitBreaker(Integer id) {
        if(id < 0){
            throw new RuntimeException("****** id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName() + "\t 调用成功 流水号: " + serialNumber ;
    }

    public String paymentCircuitBreaker_fallback(Integer id){
        return "id不能为负数 o(╥﹏╥)o 请稍后重试~";
    }
}
