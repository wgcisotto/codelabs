package com.code.labs.hackerrank.arrays.basic.FindSmallestMissingPositiveInteger;

import java.util.List;

public class Solution {

    /*
     * Complete the 'findSmallestMissingPositive' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY orderNumbers as parameter.
     */

    public static int findSmallestMissingPositive(List<Integer> orderNumbers) {
        // Write your code here
        //TODO:: continue from here
        if (orderNumbers.isEmpty()){
            return 1;
        }

        List<Integer> sortedNumbers = orderNumbers.stream().sorted(Integer::compareTo).toList();

        Integer missingNumber = 1;
        for (int i = 0; i < sortedNumbers.size(); i++){
            Integer current = sortedNumbers.get(i);
            if (current >= 0 && current.equals(missingNumber)) {
                missingNumber++;
            }
        }

        return missingNumber;
    }

}
