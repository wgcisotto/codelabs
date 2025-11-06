package com.code.labs.concurrency;

import com.code.labs.concurrency.model.Counter;

import java.util.ArrayList;
import java.util.List;

public class ConcurrentCounter {

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        int numThreads = 6;
        int incrementPerThread = 10000;

        Runnable incrementor = () -> {
            for (int i = 0; i < incrementPerThread; i++) {
                counter.increment();
                // Optional logging for tracking progress
                if (i % 1000 == 0) {
                    Thread thread = Thread.currentThread();
                    System.out.printf("Thread[%s] reached %d increments%n", thread.getId(), i);
                }
            }
        };

        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < numThreads; i++) {
            Thread thread = new Thread(incrementor);
            threadList.add(thread);
            thread.start();
        }

        // Wait for all threads to finish
        for (Thread thread : threadList) {
            thread.join();
        }

        // Print the final value of the counter
        System.out.printf("Final Counter = %s%n", counter.get());
    }
}
