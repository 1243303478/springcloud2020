package com.atzy.springcloud.service;

import java.math.BigDecimal;

public interface AccountService {

    void changeAccount(long userId, BigDecimal money);
}
