package com.atzy.springcloud.payment.service.impl;

import com.atzy.springcloud.beans.Payment;
import com.atzy.springcloud.payment.dao.PaymentDao;
import com.atzy.springcloud.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    PaymentDao paymentDao;

    @Override
    public int createPayment(Payment payment) {
        return paymentDao.insertPayment(payment);
    }

    @Override
    public Payment getPaymentInfo(long id) {
        return paymentDao.getPaymentInfo(id);
    }
}
