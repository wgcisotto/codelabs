package com.code.labs.hackerrank.warmup.BirthdayCakeCandles;

import org.junit.jupiter.api.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testAllDistinctHeights() {
        List<Integer> candles = Arrays.asList(1, 2, 3, 4, 5);
        // tallest is 5, only one of them
        assertEquals(1, Solution.birthdayCakeCandles(candles));
    }

    @Test
    void testMultipleTallestHeights() {
        List<Integer> candles = Arrays.asList(3, 2, 1, 3);
        // tallest is 3, two of them
        assertEquals(2, Solution.birthdayCakeCandles(candles));
    }

    @Test
    void testAllSameHeight() {
        List<Integer> candles = Arrays.asList(4, 4, 4, 4);
        // tallest is 4, four of them
        assertEquals(4, Solution.birthdayCakeCandles(candles));
    }

    @Test
    void testLargeNumbers() {
        List<Integer> candles = Arrays.asList(1000000, 999999, 1000000, 1000000);
        // tallest is 1000000, three of them
        assertEquals(3, Solution.birthdayCakeCandles(candles));
    }

    @Test
    void testSingleElement() {
        List<Integer> candles = Collections.singletonList(7);
        // only one candle, it's tallest by default
        assertEquals(1, Solution.birthdayCakeCandles(candles));
    }

    @Test
    void testUnsortedInput() {
        List<Integer> candles = Arrays.asList(2, 5, 3, 5, 1, 4, 5);
        // tallest is 5, three of them
        assertEquals(3, Solution.birthdayCakeCandles(candles));
    }

    @Test
    void testNegativeOrZeroHeightsEdgeCase() {
        // if your domain allows non-positive values (though HackerRank says 1 <= candles[i]), you might test this
        List<Integer> candles = Arrays.asList(0, -1, 0, -1);
        // tallest is 0, two of them
        assertEquals(2, Solution.birthdayCakeCandles(candles));
    }

    @Test
    void testEmptyListThrowsException() {
        List<Integer> candles = Collections.emptyList();
        Exception e = assertThrows(IllegalArgumentException.class,
                () -> Solution.birthdayCakeCandles(candles));
        // Optionally check exception message if your implementation provides one
    }

    @Test
    void testNullListThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> Solution.birthdayCakeCandles(null));
    }

}