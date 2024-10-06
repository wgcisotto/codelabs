package com.code.labs.codechallenges.rvlt.loadbalancer.model;

public class BackendConfig {
    private final String address;

    public BackendConfig(String address){
        if (address == null || address.isEmpty()) {
            throw new IllegalArgumentException(String.format("Invalid address[%s]", address));
        }
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

}