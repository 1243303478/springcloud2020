package com.atzy.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA() {
        return "-------testA";
    }

    @GetMapping("/testB")
    public String testB() {
        return "-------testB";
    }

    @GetMapping("/testC")
    public String testC() {
        return testA();
    }

    @GetMapping("/testD")
    public String testD() {
        int a = 10 / 0;
        /*try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        System.out.println("testD 测试");
        return "--------testD";
    }

    @SentinelResource(value = "testHotKey", blockHandler = "testFExceptionHandler",blockHandlerClass = FlowLimitController.class,fallback = "exceptionHandler")
    @GetMapping("/testF")
    public String testF(@RequestParam(value = "k1", required = false) String k1, @RequestParam(value = "k2", required = false) String k2) {
        System.out.println("testF 测试");
        return "--------testF";
    }

    public String testFExceptionHandler(@RequestParam(value = "k1", required = false) String k1, @RequestParam(value = "k2", required = false)String k2) {
        return "错误兜底方法 服务降级了...";
    }

    public String exceptionHandler(@RequestParam(value = "k1", required = false) String k1, @RequestParam(value = "k2", required = false)String k2) {
        System.out.println("异常了...");
        return "java类错误兜底方法 服务降级了...";
    }
}
