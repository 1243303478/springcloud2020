package com.atzy.springcloud.service;

import com.atzy.springcloud.domain.Order;

public interface OrderService {
    /**
     * 创建一个新的订单
     * @param order
     * @return
     */
    Order createOrder(Order order);

    /**
     * 修改对应id订单的状态
     * @param id
     * @param status
     *//*
    void changeOrderStatus(long id,Integer status);*/
}
