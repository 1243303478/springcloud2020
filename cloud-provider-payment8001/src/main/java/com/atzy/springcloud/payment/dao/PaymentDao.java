package com.atzy.springcloud.payment.dao;

import com.atzy.springcloud.beans.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {
    int insertPayment(@Param("payment")Payment payment);

    /**
     * 根据传进来的id 查询对应serial
     * @param id
     * @return
     */
    Payment getPaymentInfo(@Param("id") long id);
}
