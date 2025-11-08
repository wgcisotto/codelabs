package com.code.labs.hackerrank.warmup.PlusMinus;

import org.junit.jupiter.api.*;
import java.io.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }

    private String getOutput() {
        return outputStream.toString().trim();
    }

    @Test
    void testAllPositive() {
        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5);
        Solution.plusMinus(arr);
        String[] lines = getOutput().split("\\r?\\n");
        assertEquals("1.000000", lines[0]);
        assertEquals("0.000000", lines[1]);
        assertEquals("0.000000", lines[2]);
    }

    @Test
    void testAllNegative() {
        List<Integer> arr = Arrays.asList(-1, -2, -3);
        Solution.plusMinus(arr);
        String[] lines = getOutput().split("\\r?\\n");
        assertEquals("0.000000", lines[0]);
        assertEquals("1.000000", lines[1]);
        assertEquals("0.000000", lines[2]);
    }

    @Test
    void testAllZero() {
        List<Integer> arr = Arrays.asList(0, 0, 0, 0);
        Solution.plusMinus(arr);
        String[] lines = getOutput().split("\\r?\\n");
        assertEquals("0.000000", lines[0]);
        assertEquals("0.000000", lines[1]);
        assertEquals("1.000000", lines[2]);
    }

    @Test
    void testMixedValues() {
        List<Integer> arr = Arrays.asList(-4, 3, -9, 0, 4, 1);
        Solution.plusMinus(arr);
        String[] lines = getOutput().split("\\r?\\n");
        assertEquals("0.500000", lines[0]);
        assertEquals("0.333333", lines[1]);
        assertEquals("0.166667", lines[2]);
    }
}
