package com.code.labs.algorithms.searching;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BinarySearchTest {


    @Test
    void binarySearch_thenSuccess(){
        int[] sortedArray = new int[]{1,2,3,4,5,6,7,8,9};
        BinarySearch binarySearch = new BinarySearch(sortedArray);

        Assertions.assertEquals(0, binarySearch.search(1));
        Assertions.assertEquals(4, binarySearch.search(5));
        Assertions.assertEquals(8, binarySearch.search(9));
        Assertions.assertEquals(-1, binarySearch.search(0));
    }


}