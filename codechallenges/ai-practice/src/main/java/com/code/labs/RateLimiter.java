package com.code.labs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class RateLimiter {
    

    Map<String, Deque<Integer>> requests = new HashMap<>();
    public static void main(String[] args) {

    }

    public boolean request(String userId, int timestamp) {
        Deque<Integer> deque = requests.computeIfAbsent(
                userId, _ -> new ArrayDeque<>()
        );

        while (!deque.isEmpty() && deque.getFirst() < timestamp - 60) {
            deque.pollFirst();
        }
        if (deque.size() >= 100) {
            return  false;
        }
        deque.add(timestamp);
        return false;
    }

}
