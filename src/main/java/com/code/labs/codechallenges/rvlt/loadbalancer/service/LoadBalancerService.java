package com.code.labs.codechallenges.rvlt.loadbalancer.service;

import com.code.labs.codechallenges.rvlt.loadbalancer.model.BackendConfig;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

public class LoadBalancerService {

    Map<String, BackendConfig> backendList = new LinkedHashMap<>();

    private int next;

    public BackendConfig get(String address){
        return backendList.get(address);
    }

    public BackendConfig getRandom(Random generator) {
        int i = generator.nextInt(backendList.size());
        Object[] array = backendList.keySet().toArray();
        return backendList.get(array[i]);
    }

    public BackendConfig getNextRoundingRobin(){
        if(next >= getSize()){
            next = 0;
        }
        Object[] array = backendList.keySet().toArray();
        return backendList.get(array[next++]);
    }

    public BackendConfig add(String addres){
        BackendConfig backendConfig = new BackendConfig(addres);
        backendList.put(addres, backendConfig);
        return backendConfig;
    }

    public int getSize(){
        return backendList.size();
    }

}
