package com.code.labs.codechallenges.rvlt.loadbalancer.service;

import com.code.labs.codechallenges.rvlt.loadbalancer.model.InstanceRecord;

import javax.naming.SizeLimitExceededException;
import java.util.LinkedHashMap;
import java.util.Map;

abstract class LoadBalancerDefault implements LoadBalancer {
    public static final int LIMIT = 10;
    Map<String, InstanceRecord> instances = new LinkedHashMap<>();

    @Override
    public InstanceRecord register(String address) throws SizeLimitExceededException {
        if(address == null || address.isEmpty()){
            throw new IllegalArgumentException(String.format("Invalid address[%s]", address));
        }
        // ("\\d{3}.[a-zA-Z\\W]\\.\\d\\.([134])\\.\\d{1,2}")
        if (!address.matches("\\d{3}\\.\\d\\.\\d\\.\\d{1,2}")){
            throw new IllegalArgumentException(String.format("Invalid address[%s]", address));
        }

        if (instances.size() == LIMIT){
            throw new SizeLimitExceededException(String.format("No more space available. Limit[%s]", LIMIT));
        }

        InstanceRecord instance = new InstanceRecord(address);
        instances.put(address, instance);

        return instance;
    }

}
