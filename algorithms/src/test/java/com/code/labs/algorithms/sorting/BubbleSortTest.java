package com.code.labs.algorithms.sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.code.labs.utils.ArrayUtils.isSorted;

class BubbleSortTest {

    @Test
    void sort_thenSuccess(){
        BubbleSort bubbleSort = new BubbleSort(new int[]{9,2,3,7,6,1,5,4,8});
        int[] sorted = bubbleSort.sort();
        Assertions.assertTrue(isSorted(sorted));
    }

}