package com.code.labs.utils;

public class ArrayUtils {
    public static boolean isSorted(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                return false; // Array is not sorted
            }
        }
        return true; // Array is sorted
    }
}