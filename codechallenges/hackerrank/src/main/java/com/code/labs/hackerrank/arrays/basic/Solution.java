package com.code.labs.hackerrank.arrays.basic;

import java.util.List;

public class Solution {

    /*
     * Complete the 'countResponseTimeRegressions' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY responseTimes as parameter.
     */
    public static int countResponseTimeRegressions(List<Integer> responseTimes) {
        if (responseTimes == null || responseTimes.size() <= 1) return 0;

        int count = 0;
        long sum = responseTimes.get(0);

        for (int i = 1; i < responseTimes.size(); i++) {
            double avg = sum / (double) i;  // average of all previous elements
            if (responseTimes.get(i) > avg) {
                count++;
            }
            sum += responseTimes.get(i);
        }

        return count;
    }

}
