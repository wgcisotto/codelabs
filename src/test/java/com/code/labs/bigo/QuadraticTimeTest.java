package com.code.labs.bigo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.code.labs.utils.ArrayUtils.isSorted;

// Quadratic Time Complexity O(n²)
class QuadraticTimeTest {

    @Test
    void bubbleSort_thenSuccess(){
        QuadraticTime quadraticTime = new QuadraticTime(new int[]{9,2,3,7,6,1,5,4,8});
        int[] sorted = quadraticTime.bubbleSort();
        Assertions.assertTrue(isSorted(sorted));
    }

}