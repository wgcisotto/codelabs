package com.code.labs.codechallenges.rvlt.loadbalancer.service;

import com.code.labs.codechallenges.rvlt.loadbalancer.model.InstanceRecord;

import java.util.Random;

public class RandomLoadBalancer extends LoadBalancerDefault {

    @Override
    public InstanceRecord get() {
        Random generator = new Random();
        int i = generator.nextInt(instances.size());
        Object[] array = instances.keySet().toArray();
        return instances.get(array[i]);
    }

}
