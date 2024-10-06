package com.code.labs.codechallenges.rvlt.loadbalancer.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BackendConfigTest {

    @Test
    void getAddress_thenSuccess(){
        String address = "127.0.0.1";
        BackendConfig backendConfig = new BackendConfig(address);
        assertFalse(backendConfig.getAddress().isBlank());
        assertEquals(address, backendConfig.getAddress());
    }

    @Test
    void newInstance_thenException(){
        assertThrows(IllegalArgumentException.class, () -> new BackendConfig(null));
    }

}