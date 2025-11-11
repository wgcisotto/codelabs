package com.code.labs.hackerrank.warmup.BirthdayCakeCandles;

import java.util.Comparator;
import java.util.List;

public class Solution {
    /*
     * Complete the 'birthdayCakeCandles' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY candles as parameter.
     */

    public static int birthdayCakeCandles(List<Integer> candles) {
        // Write your code here
        if(candles==null||candles.isEmpty()) throw new IllegalArgumentException();
        int tallestCandleCount = 0;
        candles.sort(Comparator.naturalOrder());
        int tallestSize = candles.get(candles.size()-1);
        for (int i=0; i < candles.size(); i++){
            if(candles.get(i).equals(tallestSize)){
                tallestCandleCount++;
            }
        }
        return tallestCandleCount;
    }

}
