package com.code.labs.hackerrank.warmup.PlusMinus;

import java.util.List;

public class Solution {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        int positive = 0;
        int negative = 0;
        int zero = 0;

        for (int i = 0; i < arr.size(); i++){
            int num = arr.get(i);
            if (num == 0){
                zero++;
            } else if (num > 0) {
                positive++;
            } else {
                negative++;
            }
        }

        int[] result = {positive, negative, zero};

        for (int i = 0; i < result.length; i++) {
            int sum = result[i];
            int size = arr.size();
            double ratio = (double) sum/size;
            System.out.printf("%.6f%n", ratio);
        }

    }
}
