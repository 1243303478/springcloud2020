package com.atzy.springcloud.service;

import java.math.BigDecimal;

public interface AccountService {
    /**
     * 减少对应用户余额 (money 增减余额)
     * @param userId
     * @param money
     */
    void changeAccount(long userId, BigDecimal money);
}
