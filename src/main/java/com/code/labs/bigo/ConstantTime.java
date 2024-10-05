package com.code.labs.bigo;

/**
 * The {@code ConstantTime} class demonstrates an example of constant time complexity (O(1)).
 * It provides a method to retrieve an element from an array by its index, which is an O(1) operation.
 *
 * <p>
 * Time Complexity:
 * - The {@code findByIndex} method runs in constant time, O(1), because array indexing in Java is a direct memory access operation.
 *   Regardless of the size of the array, accessing a specific index takes the same amount of time.
 * </p>
 *
 * <p>
 * Space Complexity:
 * - The space complexity of this class is O(n), where n is the size of the input array.
 *   The method does not allocate any additional space that grows with the input size.
 *   It only uses a fixed amount of memory for the variables used (the index parameter and any temporary variables).
 * </p>
 */

//Constant Time = O(1)
public class ConstantTime extends BigOArray {

    public ConstantTime(int[] array){
        super(array);
    }

    // Time Complexity O(1)
    // Space Complexity O(1)
    public int findByIndex(int index) {
        if(index < 0 || index >= data.length) {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + data.length);
        }
        return data[index];
    }

    public int length() {
        return data.length;
    }
}
