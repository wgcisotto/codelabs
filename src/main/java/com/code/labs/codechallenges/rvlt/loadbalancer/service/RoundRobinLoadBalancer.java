package com.code.labs.codechallenges.rvlt.loadbalancer.service;

import com.code.labs.codechallenges.rvlt.loadbalancer.model.InstanceRecord;

import java.util.concurrent.locks.ReentrantLock;

public class RoundRobinLoadBalancer extends LoadBalancerDefault {

    ReentrantLock reentrantLock = new ReentrantLock();
    private int next;

    // Time complexity: O(n) - iterating over the keySet to create the array
    // Space complexity: O(n) - the array size grows with the number of keys in the keySet
    @Override
    public InstanceRecord get() {
        reentrantLock.lock();
        if(next >= instances.size()){
            next = 0;
        }
        InstanceRecord instance;
        try {
            Object[] array = instances.keySet().toArray();
            instance = instances.get(array[next++]);
        } catch (Exception e){
            throw new RuntimeException("Failed to get instance");
        } finally {
            reentrantLock.unlock();
        }
        return instance;
    }
}
