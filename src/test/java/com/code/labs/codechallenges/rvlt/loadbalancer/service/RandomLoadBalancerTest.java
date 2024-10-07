package com.code.labs.codechallenges.rvlt.loadbalancer.service;

import com.code.labs.codechallenges.rvlt.loadbalancer.model.InstanceRecord;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import javax.naming.SizeLimitExceededException;
import java.util.Objects;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class RandomLoadBalancerTest {

    RandomLoadBalancer service;

    @BeforeEach
    void setUp() throws SizeLimitExceededException {
        service = new RandomLoadBalancer();
        service.register("127.0.0.1");
        service.register("127.0.0.2");
        service.register("127.0.0.3");
    }
    @Test
    void get_thenSuccess() {
        Assertions.assertTrue(Objects.nonNull(service.get()));
    }

    @Test
    void register_thenSuccess() throws SizeLimitExceededException {
        InstanceRecord instanceRecord = service.register("127.0.0.4");
        assertEquals("127.0.0.4", instanceRecord.address());
    }

    @Test
    void register_thenIllegalArgumentExceptionIsThrown() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> service.register("127.0.10.455"));
    }

    @Test
    void getRandom_thenSuccess(){
        InstanceRecord random = service.get();
        Assertions.assertTrue(Objects.nonNull(random.address()));

    }

    @Test
    void register_thenLimitException() throws SizeLimitExceededException {
        service.register("127.0.0.4");
        service.register("127.0.0.5");
        service.register("127.0.0.6");
        service.register("127.0.0.7");
        service.register("127.0.0.8");
        service.register("127.0.0.9");
        service.register("127.0.0.10");

        Assertions.assertThrows(SizeLimitExceededException.class, () -> service.register("127.0.0.10"));

    }

}