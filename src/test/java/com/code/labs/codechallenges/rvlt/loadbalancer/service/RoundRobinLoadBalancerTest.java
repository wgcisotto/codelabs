package com.code.labs.codechallenges.rvlt.loadbalancer.service;

import com.code.labs.codechallenges.rvlt.loadbalancer.model.InstanceRecord;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.naming.SizeLimitExceededException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class RoundRobinLoadBalancerTest {

    RoundRobinLoadBalancer loadBalancer;

    @BeforeEach
    void setUp() throws SizeLimitExceededException {
        loadBalancer = new RoundRobinLoadBalancer();
        loadBalancer.register("127.0.0.1");
        loadBalancer.register("127.0.0.2");
        loadBalancer.register("127.0.0.3");
    }

    @Test
    void get_thenSuccess() {
        Assertions.assertTrue(Objects.nonNull(loadBalancer.get()));
    }

    @Test
    void register_thenSuccess() throws SizeLimitExceededException {
        InstanceRecord instanceRecord = loadBalancer.register("127.0.0.4");
        assertEquals("127.0.0.4", instanceRecord.address());
    }

    @Test
    void getRandom_thenSuccess(){
        InstanceRecord random = loadBalancer.get();
        Assertions.assertTrue(Objects.nonNull(random.address()));

    }

    @Test
    void getNextRoundingRobin_ThenSuccess() throws SizeLimitExceededException {
        Assertions.assertEquals("127.0.0.1", loadBalancer.get().address());
        Assertions.assertEquals("127.0.0.2", loadBalancer.get().address());
        Assertions.assertEquals("127.0.0.3", loadBalancer.get().address());

        loadBalancer.register("127.0.0.4");

        Assertions.assertEquals("127.0.0.4", loadBalancer.get().address());
        Assertions.assertEquals("127.0.0.1", loadBalancer.get().address());
        Assertions.assertEquals("127.0.0.2", loadBalancer.get().address());
        Assertions.assertEquals("127.0.0.3", loadBalancer.get().address());
    }

    @Test
    void register_thenLimitException() throws SizeLimitExceededException {
        loadBalancer.register("127.0.0.4");
        loadBalancer.register("127.0.0.5");
        loadBalancer.register("127.0.0.6");
        loadBalancer.register("127.0.0.7");
        loadBalancer.register("127.0.0.8");
        loadBalancer.register("127.0.0.9");
        loadBalancer.register("127.0.0.10");

        Assertions.assertThrows(SizeLimitExceededException.class, () -> loadBalancer.register("127.0.0.10"));

    }

    @Test
    void testConcurrentAccess() throws ExecutionException, InterruptedException {
        var numberOfThreads = 9;
        ExecutorService executor = Executors.newFixedThreadPool(9);
        Callable<InstanceRecord> task = loadBalancer::get;

        List<Future<InstanceRecord>> futures = new ArrayList<>();
        for (int i = 0; i < numberOfThreads; i++ ){
            futures.add(executor.submit(task));
        }
        // Expected round-robin order over 3 cycles
        List<String> expectedOrder = Arrays.asList("127.0.0.1", "127.0.0.2", "127.0.0.3", "127.0.0.1", "127.0.0.2", "127.0.0.3", "127.0.0.1","127.0.0.2", "127.0.0.3");


        List<String> actualOrder = new ArrayList<>();
        for (Future<InstanceRecord> future : futures) {
            InstanceRecord instanceRecord = future.get();
            actualOrder.add(instanceRecord.address());
        }

        assertEquals(expectedOrder, actualOrder);

        executor.shutdown();
    }

}