package com.code.labs.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrentAtomicCounter {


    public static void main(String[] args) throws InterruptedException {

        AtomicInteger counter = new AtomicInteger();

        Runnable incrementor = () -> {
            Thread thread = Thread.currentThread();
            for (int i = 0; i < 10; i++){
                counter.getAndIncrement();
                System.out.printf("Thread[%s] - %s%n", thread.getId(), counter);
            }

        };

        Thread r1 = new Thread(incrementor);
        Thread r2 = new Thread(incrementor);

        r1.start();
        r2.start();

        // Wait for threads to complete before continuing
        r1.join();
        r2.join();

        // Print the final value of the counter
        System.out.printf("Final Counter = %s%n", counter.get());


    }

}
