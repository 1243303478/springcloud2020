package com.atzy.springcloud.service.impl;

import com.atzy.springcloud.dao.AccountDao;
import com.atzy.springcloud.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Service
public class AccountServiceImpl implements AccountService {
    @Resource
    AccountDao accountDao;
    @Override
    public void changeAccount(long userId, BigDecimal money) {
        accountDao.changeAccount(userId,money);
    }
}
