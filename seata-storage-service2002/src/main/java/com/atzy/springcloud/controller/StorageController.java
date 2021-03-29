package com.atzy.springcloud.controller;

import com.atzy.springcloud.domain.CommonResult;
import com.atzy.springcloud.domain.Storage;
import com.atzy.springcloud.service.StorageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class StorageController {

    @Resource
    StorageService storageService;

    @PostMapping("/storage/change")
    public CommonResult<Object> changeStorage(long productId,Integer num){
        Storage result = storageService.changeStorage(productId,num);
        if(result != null){
            new CommonResult<Storage>(200,"操作成功",result);
        }
        return new CommonResult<>(444,"操作失败",null);
    }

}
