package com.code.labs.bigo;

public class BigOArray {

    protected int[] data;

    public BigOArray(int[] data) {
        if (data == null){
            throw new IllegalArgumentException("Array must not be null");
        }
        this.data = data;
    }

}
