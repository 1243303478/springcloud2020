package com.atzy.springcloud.service.impl;

import com.atzy.springcloud.dao.OrderDao;
import com.atzy.springcloud.domain.Order;
import com.atzy.springcloud.service.AccountService;
import com.atzy.springcloud.service.OrderService;
import com.atzy.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @GlobalTransactional(name = "seata-create-order",rollbackFor = Exception.class)
    public void createOrder(Order orderData) {
        log.info("开始创建订单了~~~");
        int orderId = orderDao.createOrder(orderData);
        log.info("订单id = " +orderId);
        log.info("订单创建完成~~~~");
        log.info("开始扣减库存");
        storageService.changeStorage(orderData.getProductId(),orderData.getCount());
        log.info("扣减库存完成~~~开始减少用户余额");
        accountService.changeUserAccount(orderData.getUserId(),orderData.getMoney());
        log.info("修改订单状态");
        orderDao.updateOrderStatus(orderId,0);
        log.info("订单创建完成");
    }

    /*@Override
    public void changeOrderStatus(long id, Integer status) {
        orderDao.updateOrderStatus(id,status);
    }*/
}
