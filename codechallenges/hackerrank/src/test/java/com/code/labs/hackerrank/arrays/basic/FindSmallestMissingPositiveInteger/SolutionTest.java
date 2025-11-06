package com.code.labs.hackerrank.arrays.basic.FindSmallestMissingPositiveInteger;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SolutionTest {

    @Test
    void testNullArray_shouldThrowExceptionOrHandleGracefully() {
        // If your implementation throws NPE, you may assertThrows(NPE, …). If it returns 1 for null input, adapt accordingly.
        assertThrows(NullPointerException.class,
                () -> Solution.findSmallestMissingPositive(null),
                "Null input should lead to NullPointerException");
    }

    @Test
    void testEmptyArray() {
        assertEquals(1,
                Solution.findSmallestMissingPositive(List.of()),
                "Empty list ⇒ smallest missing positive = 1");
    }

    @Test
    void testAllNegativesAndZeros() {
        List<Integer> arr = new ArrayList<>(List.of(-3, -1, 0, -100));
        assertEquals(1, Solution.findSmallestMissingPositive(arr),
                "Only non-positives ⇒ answer is 1");
    }

    @Test
    void testConsecutivePositivesStartingAtOne() {
        List<Integer> arr = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        assertEquals(6, Solution.findSmallestMissingPositive(arr),
                "If all positives from 1…n present ⇒ answer is n+1");
    }

    @Test
    void testPositivesNotStartingAtOne() {
        List<Integer> arr = new ArrayList<>(List.of(2, 3, 4, 5));
        assertEquals(1, Solution.findSmallestMissingPositive(arr),
                "If 1 is missing, even though others exist ⇒ answer is 1");
    }

    @Test
    void testMixedValues_withHole() {
        List<Integer> arr = new ArrayList<>(List.of(3, 4, -1, 1));
        // classic example: values are –1,1,3,4 ⇒ missing smallest positive = 2
        assertEquals(2, Solution.findSmallestMissingPositive(arr),
                "Mixed values with missing 2 ⇒ answer = 2");
    }

    @Test
    void testDuplicatesAndUnordered() {
        List<Integer> arr = new ArrayList<>(List.of(1, 2, 2, 3, 5, 3, 1));
        // 1,2,2,3,5,3,1 ⇒ missing 4 ⇒ answer = 4
        assertEquals(4, Solution.findSmallestMissingPositive(arr),
                "Duplicates and unsorted ⇒ find gap at 4");
    }

    @Test
    void testLargeValuesOnly() {
        List<Integer> arr = new ArrayList<>(List.of(100, 101, 102));
        assertEquals(1, Solution.findSmallestMissingPositive(arr),
                "Only large positives but missing 1 ⇒ answer = 1");
    }

    @Test
    void testSingleElementPositiveOne() {
        List<Integer> arr = new ArrayList<>(List.of(1));
        assertEquals(2,
                Solution.findSmallestMissingPositive(arr),
                "Single element 1 ⇒ answer = 2");
    }

    @Test
    void testSingleElementOtherPositive() {
        List<Integer> arr = new ArrayList<>(List.of(5));
        assertEquals(1,
                Solution.findSmallestMissingPositive(arr),
                "Single element >1 ⇒ smallest missing positive is 1");
    }

    @Test
    void testSingleElementNegative() {
        List<Integer> arr = new ArrayList<>(List.of(-10));
        assertEquals(1,
                Solution.findSmallestMissingPositive(arr),
                "Single negative element ⇒ answer = 1");
    }

    @Test
    void testLargeArrayContainingFullSequenceUpToN() {
        List<Integer> arr = java.util.stream.IntStream.rangeClosed(1, 1000)
                .boxed().toList();
        assertEquals(1001,
                Solution.findSmallestMissingPositive(arr),
                "List contains 1…n ⇒ answer = n+1");
    }

    // Parameterized tests for more combinations
    private static Stream<org.junit.jupiter.params.provider.Arguments> provideArraysAndExpected() {
        return Stream.of(
                Arguments.of(new ArrayList<>(List.of(2, 3, 7, 6, 8, -1, -10, 15)), 1),
                Arguments.of(new ArrayList<>(List.of(1, 2, 0)), 3),
                Arguments.of(new ArrayList<>(List.of(1, 1, 0, -1, -2)), 2),
                Arguments.of(new ArrayList<>(List.of(1, 2, 6, 3, 5, 4)), 7),
                Arguments.of(new ArrayList<>(List.of(5, 3, 1, 2, 4, 7, 8)), 6)
        );
    }

    @ParameterizedTest
    @MethodSource("provideArraysAndExpected")
    void testVariousCases(List<Integer> arr, int expected) {
        assertEquals(expected, Solution.findSmallestMissingPositive(arr),
                "For array " + arr.toString() + " expected " + expected);
    }
}