package com.atzy.springcloud.service.impl;

import com.atzy.springcloud.dao.StorageDao;
import com.atzy.springcloud.domain.Storage;
import com.atzy.springcloud.service.StorageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StorageServiceImpl implements StorageService {

    @Resource
    StorageDao storageDao;

    @Override
    public Storage changeStorage(long productId, Integer num) {
        return storageDao.changeStorage(productId,num);
    }
}
