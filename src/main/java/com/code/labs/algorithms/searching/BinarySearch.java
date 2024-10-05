package com.code.labs.algorithms.searching;

public class BinarySearch {

    int[] data;

    public BinarySearch(int[] array){
        this.data = array;
    }

    // Time Complexity O(log n)
    // Space Complexity O(1)

    /*
        Time Complexity:
        - The time complexity is O(log n) because, in each iteration of the while loop,
          the search space is halved. This means the number of elements to be checked
          is reduced exponentially.
        - Specifically, if we start with n elements, after the first comparison, we have
          at most n/2 elements left, then n/4, n/8, and so on.
        - The process continues until the search space is exhausted or the target is found,
          which results in a logarithmic number of comparisons relative to the input size.

        Space Complexity:
        - The space complexity is O(1) because the algorithm only uses a constant amount
          of extra space regardless of the input size.
        - Specifically, we are using a fixed number of integer variables (left, right, mid)
          to keep track of the boundaries and the current index being checked.
        - No additional data structures or arrays are allocated that would grow with the input size,
          thus maintaining constant space usage.
    */
    public int search(int target){
        if (data == null || data.length == 0) {
            return -1; // Array is empty or null, target cannot be found.
        }

        int left = 0;
        int right = data.length -1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // This formula helps prevent overflow compared to (left + right) / 2.
            if (data[mid] == target) {
                return mid;
            }
            if (data[mid] < target) { // If data[mid] is less than target: This means the target must be in the right half of the
                left = mid + 1; // Search in the right half.
            } else {
                right = mid -1; // Search in the left half.
            }
        }
        return -1; // target is not in the array

    }

}
