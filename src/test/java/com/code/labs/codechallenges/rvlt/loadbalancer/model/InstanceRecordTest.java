package com.code.labs.codechallenges.rvlt.loadbalancer.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InstanceRecordTest {

    @Test
    void getAddress_thenSuccess(){
        String address = "127.0.0.1";
        InstanceRecord instanceRecord = new InstanceRecord(address);
        assertFalse(instanceRecord.address().isBlank());
        assertEquals(address, instanceRecord.address());
    }

}