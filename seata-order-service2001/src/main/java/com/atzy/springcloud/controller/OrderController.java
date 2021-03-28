package com.atzy.springcloud.controller;

import com.atzy.springcloud.domain.CommonResult;
import com.atzy.springcloud.domain.Order;
import com.atzy.springcloud.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderController {

    @Resource
    public OrderService orderService;

    @PostMapping("/order/create")
    public CommonResult<Object> payOrder(@RequestBody Order order){
        CommonResult<Object> result = new CommonResult<>();
        if(order.getUserId() != 0){
            orderService.createOrder(order);
        }
        result.setCode(444);
        result.setMsg("用户id不能为空");
        return result;
    }
}
