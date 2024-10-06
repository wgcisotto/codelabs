package com.code.labs.codechallenges.rvlt.loadbalancer.service;

import com.code.labs.codechallenges.rvlt.loadbalancer.model.BackendConfig;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class LoadBalancerServiceTest {

    LoadBalancerService service;

    @BeforeEach
    void setUp(){
        service = new LoadBalancerService();
        service.add("127.0.0.1");
        service.add("127.0.0.2");
        service.add("127.0.0.3");
    }
    @Test
    void get_thenSuccess() {
        assertEquals("127.0.0.1", service.get("127.0.0.1").getAddress());
    }

    @Test
    void add_thenSuccess() {
        BackendConfig backendConfig = service.add("127.0.0.4");
        assertEquals("127.0.0.4", backendConfig.getAddress());
    }

    @Test
    void getRandom_thenSuccess(){
        BackendConfig random = service.getRandom(new Random());
        Assertions.assertTrue(Objects.nonNull(random.getAddress()));

    }

    @Test
    void getRandomMock_thenSuccess(){
        Random mock = mock(Random.class);
        when(mock.nextInt(3)).thenReturn(2);
        BackendConfig random = service.getRandom(mock);
        Assertions.assertEquals("127.0.0.3", random.getAddress());
    }

    @Test
    void getSize_thenSuccess(){
        Assertions.assertEquals(3, service.getSize());
    }

    @Test
    void getNextRoundingRobin_ThenSuccess(){
        Assertions.assertEquals("127.0.0.1", service.getNextRoundingRobin().getAddress());
        Assertions.assertEquals("127.0.0.2", service.getNextRoundingRobin().getAddress());
        Assertions.assertEquals("127.0.0.3", service.getNextRoundingRobin().getAddress());
        service.add("127.0.0.4");
        Assertions.assertEquals("127.0.0.4", service.getNextRoundingRobin().getAddress());
        Assertions.assertEquals("127.0.0.1", service.getNextRoundingRobin().getAddress());
        Assertions.assertEquals("127.0.0.2", service.getNextRoundingRobin().getAddress());
        Assertions.assertEquals("127.0.0.3", service.getNextRoundingRobin().getAddress());
    }

}