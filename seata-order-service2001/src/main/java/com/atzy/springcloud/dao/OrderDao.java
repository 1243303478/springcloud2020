package com.atzy.springcloud.dao;

import com.atzy.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderDao {
    Order createOrder(Order order);

    void updateOrderStatus(@Param("id") long id, @Param("status") Integer status);
}
