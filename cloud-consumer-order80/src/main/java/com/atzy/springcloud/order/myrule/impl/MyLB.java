package com.atzy.springcloud.order.myrule.impl;

import com.atzy.springcloud.order.myrule.LoadBalancer;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyLB  implements LoadBalancer {
    private AtomicInteger atomicInteger =  new AtomicInteger(0);

    public final int getAndIncrement(){
        int current;
        int next;
        do {
            current = atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0:current + 1;
        }while (!this.atomicInteger.compareAndSet(current,next));
        return next;
    }

    @Override
    public ServiceInstance getInstances(List<ServiceInstance> instances) {
        if(instances == null && instances.size() <= 0){
            return null;
        }
        int current = getAndIncrement() % instances.size();
        return instances.get(current);
    }
}
