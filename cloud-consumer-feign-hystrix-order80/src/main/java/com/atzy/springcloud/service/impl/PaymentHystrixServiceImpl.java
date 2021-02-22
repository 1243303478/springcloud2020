package com.atzy.springcloud.service.impl;

import com.atzy.springcloud.service.PaymentHystrixService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@Component
public class PaymentHystrixServiceImpl implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "--------PaymentFallbackMethod back-paymentInfo_OK,o(╥﹏╥)o";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "--------PaymentFallbackMethod back-paymentInfo_TimeOut,o(╥﹏╥)o";
    }
}
