package com.code.labs.concurrency.model;

public class Counter {

    private int counter;
    public Counter (){
        counter = 0;
    }

    public synchronized void increment(){
        counter++;
    }

    public synchronized int get(){
        return counter;
    }


}
