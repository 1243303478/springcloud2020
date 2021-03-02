package com.atzy.springcloud.payment.controller;

import com.atzy.springcloud.beans.CommonResult;
import com.atzy.springcloud.beans.Payment;
import com.atzy.springcloud.payment.service.PaymentService;
import io.micrometer.core.instrument.util.TimeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @Value("${server.port}")
    private String server_port;

    @Autowired
    private DiscoveryClient discoveryClient;

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

    @GetMapping("discovery/info")
    public DiscoveryClient discoveryClientInfo(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info(service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info("当前实例信息: " + instance.getInstanceId() + "\t HOST:"+ instance.getHost() + "\t port" + instance.getPort());
        }
        log.info("discoveryClient 信息:" );
        return discoveryClient;
    }
    @GetMapping(value = "/payment/lb")
    public String getPaymentLB() {
        return server_port;
    }
    @GetMapping(value = "/payment/timeout")
    public String getPaymentTimeout() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return server_port;
    }

    @GetMapping("/payment/zipkin")
    public String paymentZipkin() {
        return "hi,i`am paymentzipkin server fall back.welcome to atguigu.hahahahahhahahah";
    }
}
