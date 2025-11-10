package com.code.labs.hackerrank.warmup.DiagonalDifference;

import org.junit.jupiter.api.*;
import java.util.*;

import static com.code.labs.hackerrank.warmup.DiagonalDifference.Solution.diagonalDifference;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testBasicCase() {
        List<List<Integer>> matrix = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(9, 8, 9)
        );
        assertEquals(2, diagonalDifference(matrix));
    }

    @Test
    void testSingleElement() {
        List<List<Integer>> matrix = Collections.singletonList(
                Collections.singletonList(5)
        );
        assertEquals(0, diagonalDifference(matrix));
    }

    @Test
    void testNegativeNumbers() {
        List<List<Integer>> matrix = Arrays.asList(
                Arrays.asList(-1, -2, -3),
                Arrays.asList(-4, -5, -6),
                Arrays.asList(-9, -8, -9)
        );
        assertEquals(2, diagonalDifference(matrix));
    }

    @Test
    void testZeroMatrix() {
        List<List<Integer>> matrix = Arrays.asList(
                Arrays.asList(0, 0, 0),
                Arrays.asList(0, 0, 0),
                Arrays.asList(0, 0, 0)
        );
        assertEquals(0, diagonalDifference(matrix));
    }

    @Test
    void testLargeMatrix() {
        List<List<Integer>> matrix = Arrays.asList(
                Arrays.asList(11, 2, 4),
                Arrays.asList(4, 5, 6),
                Arrays.asList(10, 8, -12)
        );
        assertEquals(15, diagonalDifference(matrix));
    }
}