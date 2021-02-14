package com.atzy.springcloud.payment.controller;

import com.atzy.springcloud.payment.beans.CommonResult;
import com.atzy.springcloud.payment.beans.Payment;
import com.atzy.springcloud.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PostMapping("create")
    public CommonResult<String> create(Payment payment){
        int result = paymentService.createPayment(payment);
        if(result > 0 ){
            return new CommonResult<String>(200,"插入成功!");
        }else{
            return new CommonResult<String>(0,"插入失败!");
        }
    }

    @GetMapping("get")
    public CommonResult<Payment> getPayment(Payment payment){
        CommonResult<Payment> result = null;

        Payment info = paymentService.getPaymentInfo(payment);
        if(StringUtils.isEmpty(info)){
            result = new CommonResult<>(200, "未找到对应信息!");
        }else{
            result = new CommonResult<>(200, "查询成功!");
        }
        result.setData(info);
        return result;
    }
}
