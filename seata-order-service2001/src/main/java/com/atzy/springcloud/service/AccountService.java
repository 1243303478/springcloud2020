package com.atzy.springcloud.service;

import com.atzy.springcloud.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@FeignClient(value = "seata-account-service")
public interface AccountService {
    /**
     * 减少对应用户余额 (money 增减余额)
     * @param userId
     * @param money
     */
    @PostMapping("/account/change")
    public CommonResult<Object> changeUserAccount(@RequestParam("userId") long userId, @RequestParam("money") BigDecimal money);
}
