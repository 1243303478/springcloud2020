package com.atzy.springcloud.dao;

import com.atzy.springcloud.domain.Storage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StorageDao {

    Storage changeStorage(@Param("productId") long productId,@Param("num") Integer num);
}
