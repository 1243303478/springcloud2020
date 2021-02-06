package com.atzy.springcloud.payment.service.impl;

import com.atzy.springcloud.payment.beans.Payment;
import com.atzy.springcloud.payment.dao.PaymentDao;
import com.atzy.springcloud.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentDao paymentDao;

    @Override
    public int createPayment(Payment payment) {
        return paymentDao.insertPayment(payment);
    }

    @Override
    public Payment getPaymentInfo(Payment payment) {
        return paymentDao.getPaymentInfo(payment);
    }
}
