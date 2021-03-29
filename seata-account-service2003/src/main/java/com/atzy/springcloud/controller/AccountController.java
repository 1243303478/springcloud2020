package com.atzy.springcloud.controller;

import com.atzy.springcloud.domain.CommonResult;
import com.atzy.springcloud.service.AccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

@RestController
public class AccountController {

    @Resource
    AccountService accountService;

    @PostMapping("/account/change")
    public CommonResult<Object> changeUserAccount(long userId, BigDecimal money){
        accountService.changeAccount(userId,money);
        return new CommonResult<>(200,"操作成功");
    }
}
