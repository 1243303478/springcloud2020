package com.atzy.springcloud.controller;

import com.atzy.springcloud.domain.CommonResult;
import com.atzy.springcloud.domain.Storage;
import com.atzy.springcloud.service.StorageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
public class StorageController {

    @Resource
    StorageService storageService;

    @PostMapping("/storage/change")
    public CommonResult<Object> changeStorage(@RequestParam("productId") long productId, @RequestParam("num") Integer num){
        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        storageService.changeStorage(productId,num);
        return new CommonResult<>(200,"操作成功",null);
    }

}
