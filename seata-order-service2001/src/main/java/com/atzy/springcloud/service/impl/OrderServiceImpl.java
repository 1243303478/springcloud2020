package com.atzy.springcloud.service.impl;

import com.atzy.springcloud.dao.OrderDao;
import com.atzy.springcloud.domain.Order;
import com.atzy.springcloud.service.AccountService;
import com.atzy.springcloud.service.OrderService;
import com.atzy.springcloud.service.StorageService;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Log
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    OrderDao orderDao;
    @Resource
    StorageService storageService;
    @Resource
    AccountService accountService;

    @Override
    public Order createOrder(Order orderData) {
        log.info("开始创建订单了~~~");
        Order orderInfo =  orderDao.createOrder(orderData);
        log.info("订单创建完成~~~~");
        log.info("开始扣减库存");
        storageService.changeProductStore(orderInfo.getProductId(),orderInfo.getCount());
        log.info("扣减库存完成~~~开始减少用户余额");
        accountService.changeAccount(orderInfo.getUserId(),orderInfo.getMoney());
        log.info("订单创建完成");
        return orderInfo;
    }

    /*@Override
    public void changeOrderStatus(long id, Integer status) {
        orderDao.updateOrderStatus(id,status);
    }*/
}
