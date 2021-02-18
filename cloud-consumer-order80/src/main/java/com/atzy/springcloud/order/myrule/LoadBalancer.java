package com.atzy.springcloud.order.myrule;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface LoadBalancer {
    ServiceInstance getInstances(List<ServiceInstance> instances);
}
