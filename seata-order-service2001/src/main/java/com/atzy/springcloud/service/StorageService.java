package com.atzy.springcloud.service;

import com.atzy.springcloud.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "seata-storage-service")
public interface StorageService {
    /**
     * 减少对应商品的指定库存数量
     * @param productId
     * @param num
     */
    @PostMapping("/storage/change")
    public CommonResult<Object> changeStorage(@RequestParam("productId") long productId,@RequestParam("num") Integer num);
}
