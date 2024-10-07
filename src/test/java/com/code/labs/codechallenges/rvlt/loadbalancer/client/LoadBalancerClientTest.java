package com.code.labs.codechallenges.rvlt.loadbalancer.client;

import com.code.labs.codechallenges.rvlt.loadbalancer.model.InstanceRecord;
import com.code.labs.codechallenges.rvlt.loadbalancer.model.LoadBalancerType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.naming.SizeLimitExceededException;

import java.util.Objects;

import static com.code.labs.codechallenges.rvlt.loadbalancer.model.LoadBalancerType.RANDOM;
import static com.code.labs.codechallenges.rvlt.loadbalancer.model.LoadBalancerType.ROUND_ROBIN;

class LoadBalancerClientTest {

    public static final String ADDRESS_FORMAT = "192.0.0.%s";
    LoadBalancerClient randomClient = new LoadBalancerClient(RANDOM);
    LoadBalancerClient roundRobinClient = new LoadBalancerClient(ROUND_ROBIN);

    @BeforeEach
    void setup() throws SizeLimitExceededException {
        for (int i = 1; i <= 10; i++){
            randomClient.register(String.format(ADDRESS_FORMAT, i));
            roundRobinClient.register(String.format(ADDRESS_FORMAT, i));
        }
    }

    @Test
    void getRandom_thenSuccess() {
        InstanceRecord instance = randomClient.get();
        Assertions.assertTrue(Objects.nonNull(instance));
    }

    @Test
    void getRoundRobin_thenSuccess() {
        for (int i = 1; i <= 10; i++) {
            InstanceRecord instance = roundRobinClient.get();
            Assertions.assertEquals(String.format(ADDRESS_FORMAT, i), instance.address());
        }
    }
}