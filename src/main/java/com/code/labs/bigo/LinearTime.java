package com.code.labs.bigo;

import java.util.Arrays;

//Linear Time Complexity O(n)
public class LinearTime extends BigOArray {

    public LinearTime(int[] array) {
        super(array);
    }

    public int[] getSquares() {
        // Time Complexity: O(n) - Iterate through each element once.
        // Space Complexity: O(1) - Only auxiliary space for the result array is considered.
        int[] squares = new int[data.length]; // Allocate an array of size n
        for (int i = 0; i < data.length; i++) {
            squares[i] = data[i] * data[i]; // Calculate the square of each element
        }
        return squares; // Return the new array
    }

    public int getSum() {
        // Time Complexity: O(n) - Iterate through each element once.
        // Space Complexity: O(1) - Only a single variable for the sum is used.
        int sum = 0; // Variable to store the sum
        for (int i = 0; i < data.length; i++) {
            sum += data[i]; // Accumulate the sum of elements
        }
        return sum; // Return the total sum
    }

    public int getStreamSum() {
        // Time Complexity: O(n) - Sum each element in the stream.
        // Space Complexity: O(1) - No additional space is used beyond the input.
        return Arrays.stream(data).sum(); // Sum the elements using a stream
    }


}
