package com.atzy.springcloud.payment.dao;

import com.atzy.springcloud.payment.beans.Payment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentDao {
    int insertPayment(Payment payment);

    Payment getPaymentInfo(Payment payment);
}
