package com.code.labs.bigo;

import com.code.labs.algorithms.searching.BinarySearch;

//Logarithmic Time Complexity O(log n)
public class LogarithmicTime extends BigOArray{

    public LogarithmicTime(int[] data) {
        super(data);
    }

    // Binary search is an O(log n) algorithm.
    public int binarySearch(int target) {
        BinarySearch binarySearch = new BinarySearch(data);
        return binarySearch.search(target);
    }
}
