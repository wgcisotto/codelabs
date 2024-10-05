package com.code.labs.bigo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ConstantTimeTest {

    private ConstantTime constantTime;

    @Test
    void findByIndex_thenSuccess() {
        constantTime = new ConstantTime(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        Assertions.assertEquals(1, constantTime.findByIndex(0));
        Assertions.assertEquals(5, constantTime.findByIndex(4));
        Assertions.assertEquals(9, constantTime.findByIndex(8));
    }

    @Test
    void findByIndex_thenError_ArrayOutOfBounds() {
        constantTime = new ConstantTime(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> constantTime.findByIndex(10));
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> constantTime.findByIndex(-1));
    }

    @Test
    void findByIndex_onEmptyArray() {
        constantTime = new ConstantTime(new int[]{});
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> constantTime.findByIndex(0));
    }

    @Test
    void constructor_thenSuccess() {
        constantTime = new ConstantTime(new int[]{10, 20, 30});
        Assertions.assertEquals(3, constantTime.length());
    }

    @Test
    void constructor_thenError_NullArray() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new ConstantTime(null));
    }

    @Test
    void length_ofArray() {
        constantTime = new ConstantTime(new int[]{1, 2, 3});
        Assertions.assertEquals(3, constantTime.length());

        constantTime = new ConstantTime(new int[]{});
        Assertions.assertEquals(0, constantTime.length());
    }

}
