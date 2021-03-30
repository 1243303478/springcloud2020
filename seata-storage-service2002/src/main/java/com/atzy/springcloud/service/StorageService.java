package com.atzy.springcloud.service;

import com.atzy.springcloud.domain.Storage;

public interface StorageService {

    void changeStorage(long productId, Integer num);
}
