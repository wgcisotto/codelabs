package com.code.labs.codechallenges.rvlt.loadbalancer.client;

import com.code.labs.codechallenges.rvlt.loadbalancer.model.InstanceRecord;
import com.code.labs.codechallenges.rvlt.loadbalancer.model.LoadBalancerType;
import com.code.labs.codechallenges.rvlt.loadbalancer.service.LoadBalancer;
import com.code.labs.codechallenges.rvlt.loadbalancer.service.RandomLoadBalancer;
import com.code.labs.codechallenges.rvlt.loadbalancer.service.RoundRobinLoadBalancer;

import javax.naming.SizeLimitExceededException;

public class LoadBalancerClient {

    private final LoadBalancer loadBalancer;

    public LoadBalancerClient(LoadBalancerType type){
        loadBalancer = switch (type){
            case RANDOM -> new RandomLoadBalancer();
            case ROUND_ROBIN -> new RoundRobinLoadBalancer();
        };
    }

    public void register(String address) throws SizeLimitExceededException {
        loadBalancer.register(address);
    }

    public InstanceRecord get() {
        return loadBalancer.get();
    }

}
