package com.atzy.springcloud.service;

public interface StorageService {
    /**
     * 减少对应商品的指定库存数量
     * @param productId
     * @param num
     */
    void changeProductStore(long productId,Integer num);
}
