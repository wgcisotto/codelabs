package com.code.labs.hackerrank.warmup.MiniMaxSum;

import java.util.Comparator;
import java.util.List;

public class Solution {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
        if(arr==null || arr.isEmpty()) throw new IllegalArgumentException();
        long minSum = 0;
        long maxSum = 0;
        arr.sort(Comparator.naturalOrder());
        for (int i=0; i < arr.size(); i++){
            if(i < arr.size()-1){
                minSum += arr.get(i);
            }
            if(i > 0){
                maxSum += arr.get(arr.size()-i);
            }
        }
        System.out.println(minSum + " " + maxSum);
    }
}
