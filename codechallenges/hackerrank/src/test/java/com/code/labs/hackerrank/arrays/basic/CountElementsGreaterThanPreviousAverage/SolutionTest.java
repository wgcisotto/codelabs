package com.code.labs.hackerrank.arrays.basic.CountElementsGreaterThanPreviousAverage;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testNullInput() {
        assertEquals(0, Solution.countResponseTimeRegressions(null),
                "Null input should return 0");
    }

    @Test
    void testEmptyList() {
        assertEquals(0, Solution.countResponseTimeRegressions(List.of()),
                "Empty list should return 0");
    }

    @Test
    void testSingleElement() {
        assertEquals(0, Solution.countResponseTimeRegressions(List.of(100)),
                "Single element list should return 0");
    }

    @Test
    void testAllIncreasing() {
        List<Integer> input = List.of(100, 200, 300, 400);
        // Step analysis:
        // avg before 200 = 100 → 200 > 100 → count=1
        // avg before 300 = (100+200)/2=150 → 300 > 150 → count=2
        // avg before 400 = (100+200+300)/3=200 → 400 > 200 → count=3
        assertEquals(3, Solution.countResponseTimeRegressions(input));
    }

    @Test
    void testAllDecreasing() {
        List<Integer> input = List.of(400, 300, 200, 100);
        // No element is greater than the previous average
        assertEquals(0, Solution.countResponseTimeRegressions(input));
    }

    @Test
    void testMixedValues() {
        List<Integer> input = List.of(100, 120, 80, 200, 150);
        // avg before 120 = 100 → 120>100 → count=1
        // avg before 80 = (100+120)/2=110 → 80<110 → count=1
        // avg before 200 = (100+120+80)/3=100 → 200>100 → count=2
        // avg before 150 = (100+120+80+200)/4=125 → 150>125 → count=3
        assertEquals(3, Solution.countResponseTimeRegressions(input));
    }

    @Test
    void testConstantValues() {
        List<Integer> input = List.of(100, 100, 100, 100);
        // All equal, none greater than average
        assertEquals(0, Solution.countResponseTimeRegressions(input));
    }

    @Test
    void testLargeValues() {
        List<Integer> input = List.of(1_000_000_000, 2_000_000_000);
        // avg before 2B = 1B → 2B > 1B → count=1
        // avg before 3B = (1B+2B)/2=1.5B → 3B > 1.5B → count=2
        assertEquals(1, Solution.countResponseTimeRegressions(input));
    }
}
