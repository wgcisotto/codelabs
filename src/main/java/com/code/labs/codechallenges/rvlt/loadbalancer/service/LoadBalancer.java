package com.code.labs.codechallenges.rvlt.loadbalancer.service;

import com.code.labs.codechallenges.rvlt.loadbalancer.model.InstanceRecord;

import javax.naming.SizeLimitExceededException;

public interface LoadBalancer {
    InstanceRecord register(String address) throws SizeLimitExceededException;

    InstanceRecord get();
}
