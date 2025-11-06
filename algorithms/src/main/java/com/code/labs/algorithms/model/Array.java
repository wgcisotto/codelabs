package com.code.labs.algorithms.model;

public class Array {
    protected int[] data;

    public Array(int[] data) {
        if (data == null){
            throw new IllegalArgumentException("Array must not be null");
        }
        this.data = data;
    }
}
