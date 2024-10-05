package com.code.labs.algorithms.sorting;

import com.code.labs.bigo.BigOArray;

public class BubbleSort extends BigOArray {
    public BubbleSort(int[] data) {
        super(data);
    }

    /*
     * Time Complexity: O(n^2) Quadratic
     * - Reason: The algorithm uses two nested loops.
     * - The outer loop runs n times, where n is the length of the array.
     * - The inner loop runs approximately n - i times for each iteration of the outer loop.
     * - This results in approximately n * (n - 1) / 2 total comparisons, which simplifies to O(n^2).
     *
     * Space Complexity: O(1) Constant
     * - Reason: The algorithm only uses a few extra variables (like swapped, temp, etc.).
     * - The amount of memory required does not depend on the input size; hence, space complexity is constant.
     */
    public int[] sort(){
        boolean swapped;
        int upperBound = data.length - 1;
        for (int i = 0; i < upperBound; i++){
            swapped = false; // Reset the flag for each outer loop iteration
            for(int x = 0; x < upperBound -i; x++){
                // -i
                // Each iteration of the outer loop places the largest element in its correct position at the end of the array.
                // Therefore, we reduce the inner loop range by 'i' to avoid rechecking already sorted elements.
             if(data[x] > data[x + 1]){ // Compare adjacent elements
                 int temp = data[x];
                 data[x] = data[x + 1];
                 data[x + 1] = temp;
                 swapped = true;
             }
            }
            // If no swaps occurred, the array is sorted
            if (!swapped){
                break;
            }
        }

        return data;
    }

}
