package com.atzy.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class SentinelFeignFallbackServiceImpl implements FeignService {
    @Override
    public String info() {
        return "兜底方法";
    }
}
