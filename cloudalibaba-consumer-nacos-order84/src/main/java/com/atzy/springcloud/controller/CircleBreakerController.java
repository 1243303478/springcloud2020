package com.atzy.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atzy.springcloud.beans.CommonResult;
import com.atzy.springcloud.beans.Payment;
import com.atzy.springcloud.service.FeignService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class CircleBreakerController {

    @Value("${service-url.nacos-user-service}")
    public String nacos_user_service;

    @Resource
    RestTemplate restTemplate;

    @Resource
    FeignService feignService;
    @GetMapping("/consumer/payment/lb/{id}")
    @SentinelResource(value = "getUserService",blockHandler = "userServiceBlockHandler",fallback = "userServiceExceptionHandler")
    public String getUserService(@PathVariable("id")Integer id){
        String result = restTemplate.getForObject(nacos_user_service + "/payment/ali/lb",String.class);
        if (id==4) {
            throw new IllegalArgumentException("IllegalArgumentException,非法参数异常....");
        } else if (result == null) {
            throw new NullPointerException("NullPointerException,该ID没有对应记录，空指针异常");
        }
        return  result;
    }

    public String userServiceBlockHandler(@PathVariable("id")Integer id,BlockException e){
        return "被sentinel规则拦截 传的id= "+id + e.getMessage();
//       return new CommonResult<>(444,"被sentinel规则拦截" + e.getMessage());
    }
    public String userServiceExceptionHandler(@PathVariable("id")Integer id){
        return "服务器异常 传的id="+id;
//        return new CommonResult<>(500,"服务器异常");
    }

    @GetMapping("/feign/payment")
    public String getFeignPayment(){
        return feignService.info();
    }
}
