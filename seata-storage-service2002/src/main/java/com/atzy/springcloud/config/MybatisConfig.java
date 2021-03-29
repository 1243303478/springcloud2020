package com.atzy.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.atzy.springcloud.dao.StorageDao")
public class MybatisConfig {

}
