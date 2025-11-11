package com.code.labs.hackerrank.warmup.MiniMaxSum;

import org.junit.jupiter.api.*;
import java.io.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private PrintStream originalOut;

    @BeforeEach
    void setUp() {
        originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void testSampleInput() {
        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5);
        Solution.miniMaxSum(arr);
        String expected = "10 14\n";
        assertEquals(expected, outputStream.toString());
    }

    @Test
    void testAllSameValues() {
        List<Integer> arr = Arrays.asList(5, 5, 5, 5, 5);
        Solution.miniMaxSum(arr);
        String expected = "20 20\n";  // sum of any four = 20
        assertEquals(expected, outputStream.toString());
    }

    @Test
    void testLargeValues() {
        List<Integer> arr = Arrays.asList(1000000000, 1000000000, 1000000000, 1000000000, 1000000000);
        Solution.miniMaxSum(arr);
        // sum of four of them = 4_000_000_000 both min and max
        String expected = "4000000000 4000000000\n";
        assertEquals(expected, outputStream.toString());
    }

    @Test
    void testMixedValues() {
        List<Integer> arr = Arrays.asList(1, 3, 5, 7, 9);
        Solution.miniMaxSum(arr);
        // min: exclude 9 => 1+3+5+7 = 16; max: exclude 1 => 3+5+7+9 = 24
        String expected = "16 24\n";
        assertEquals(expected, outputStream.toString());
    }

    @Test
    void testUnsortedInput() {
        List<Integer> arr = Arrays.asList(7, 3, 1, 9, 5);
        Solution.miniMaxSum(arr);
        // same logic as above: min=16, max=24
        String expected = "16 24\n";
        assertEquals(expected, outputStream.toString());
    }

}