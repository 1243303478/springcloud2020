package com.atzy.springcloud.hanler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atzy.springcloud.beans.CommonResult;
import com.atzy.springcloud.beans.Payment;
import org.springframework.stereotype.Component;

@Component
public class CustomExceptionHandler {

    public static CommonResult<Payment> handlerException(BlockException e){
        return new CommonResult<>(2020,"客户自定义的限流处理信息");
    }
}
