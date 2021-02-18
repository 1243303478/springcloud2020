package com.atzy.springcloud.payment.controller;

import com.atzy.springcloud.beans.CommonResult;
import com.atzy.springcloud.beans.Payment;
import com.atzy.springcloud.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @Value("${server.port}")
    private String server_port;

    @PostMapping("create")
    public CommonResult<String> create(@RequestBody Payment payment){
        int result = paymentService.createPayment(payment);
        if(result > 0 ){
            return new CommonResult<String>(200,"插入成功! 端口号:" + server_port);
        }else{
            return new CommonResult<String>(0,"插入失败! 端口号:" + server_port);
        }
    }

    @GetMapping("get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") long id){
        CommonResult<Payment> result = null;
        Payment info = paymentService.getPaymentInfo(id);
        if(StringUtils.isEmpty(info)){
            result = new CommonResult<>(200, "未找到对应信息! 端口号:" + server_port);
        }else{
            result = new CommonResult<>(200, "查询成功! 端口号:" + server_port);
        }
        result.setData(info);
        return result;
    }
    @GetMapping(value = "/payment/lb")
    public String getPaymentLB() {
        return server_port;
    }
}
