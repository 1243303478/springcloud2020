package com.atzy.springcloud.service;

public interface PaymentService {
    /**
     * 正常访问
     * @return
     */
    String paymentInfo_OK(Integer id);

    /**
     * 超时访问
     * @return
     */
    String paymentInfo_TimeOut(Integer id);


    String paymentCircuitBreaker(Integer id);
}
