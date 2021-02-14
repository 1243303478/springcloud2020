package com.atzy.springcloud.payment.service;

import com.atzy.springcloud.beans.Payment;

public interface PaymentService {
    int createPayment(Payment payment);

    Payment getPaymentInfo(long id);
}
