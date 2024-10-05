package com.code.labs.bigo;

import com.code.labs.algorithms.sorting.BubbleSort;

//Quadratic Time Complexity O(n^2)
public class QuadraticTime extends BigOArray{

    public QuadraticTime(int[] data) {
        super(data);
    }

    public int[] bubbleSort(){
        BubbleSort bubbleSort = new BubbleSort(data);
        return bubbleSort.sort();
    }

}
