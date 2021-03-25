package com.atzy.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "http://cloudalibaba-provicer-payment",fallback = SentinelFeignFallbackServiceImpl.class)
public interface FeignService {
    @GetMapping("/payment/ali/lb")
    public String info();
}
