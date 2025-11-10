package com.code.labs.hackerrank.warmup.DiagonalDifference;

import java.util.List;

public class Solution {
    /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int diagonalDifference(List<List<Integer>> arr) {
        if(arr==null || arr.isEmpty()) throw new IllegalArgumentException();
        int size = arr.size();
        int primarySum = 0;
        int secondarySum = 0;
        for (int i = 0; i < size; i++){
            primarySum += arr.get(i).get(i);
            secondarySum += arr.get(i).get(size -1 -i);
        }

//        int primarySum = IntStream.range(0, size)
//                .map(i -> matrix.get(i).get(i))
//                .sum();

//        int secondarySum = IntStream.range(0, size)
//                .map(i -> matrix.get(i).get(size - 1 - i))
//                .sum();

        return Math.abs(primarySum-secondarySum);
    }
}
