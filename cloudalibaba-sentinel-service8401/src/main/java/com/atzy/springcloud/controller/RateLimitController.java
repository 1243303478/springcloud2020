package com.atzy.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atzy.springcloud.beans.CommonResult;
import com.atzy.springcloud.beans.Payment;
import com.atzy.springcloud.hanler.CustomExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/rateLimit")
@RestController()
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandlerClass = CustomExceptionHandler.class
            ,blockHandler = "handlerException")
    public CommonResult<Payment> byResource(){
        return new CommonResult<Payment>(200,"按资源名称限流测试OK",new Payment(2020L,"serial2021"));
    }

    public CommonResult<Payment> handlerException(BlockException e){
        return new CommonResult<>(444,e.getClass().getCanonicalName() + "\t 服务不可用");
    }
}
