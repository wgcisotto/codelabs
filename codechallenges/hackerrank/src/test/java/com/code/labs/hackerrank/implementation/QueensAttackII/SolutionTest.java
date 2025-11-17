package com.code.labs.hackerrank.implementation.QueensAttackII;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testNoObstaclesSmallBoard() {
        long attackable = Solution.queensAttack(4, 0, 4, 4, Collections.emptyList());
        assertEquals(9, attackable);
    }

    @Test
    void testSingleCellBoard() {
        long attackable = Solution.queensAttack(1, 0, 1, 1, Collections.emptyList());
        assertEquals(0, attackable);
    }

    @Test
    void testObstaclesBlockAllDirections() {
        List<List<Integer>> obstacles = Arrays.asList(
                Arrays.asList(3, 2),
                Arrays.asList(3, 4),
                Arrays.asList(2, 3),
                Arrays.asList(4, 3),
                Arrays.asList(2, 2),
                Arrays.asList(2, 4),
                Arrays.asList(4, 2),
                Arrays.asList(4, 4)
        );
        long attackable = Solution.queensAttack(5, obstacles.size(), 3, 3, obstacles);
        assertEquals(0, attackable);
    }

    @Test
    void testObstaclesAtDistance() {
        List<List<Integer>> obstacles = new ArrayList<>(Arrays.asList(
                Arrays.asList(4, 7),
                Arrays.asList(7, 4),
                Arrays.asList(1, 1),
                Arrays.asList(6, 6)
        ));
        long attackable = Solution.queensAttack(8, obstacles.size(), 4, 4, obstacles);
        assertEquals(19, attackable);
    }

    @Test
    void testNoObstaclesLargeBoard() {
        long attackable = Solution.queensAttack(10, 0, 5, 5, Collections.emptyList());
        assertEquals(35, attackable);
    }

    @Test
    void testOverlappingObstaclesSameCell() {
        List<List<Integer>> obstacles = Arrays.asList(
                Arrays.asList(3, 5),
                Arrays.asList(3, 5)
        );
        long attackable = Solution.queensAttack(5, obstacles.size(), 3, 3, obstacles);
        assertEquals(15, attackable);
    }

    @Test
    void testQueenAtEdgeBoard() {
        long attackable = Solution.queensAttack(4, 0, 1, 1, Collections.emptyList());
        assertEquals(9, attackable);
    }

    @Test
    void testObstacleFarButNotOnLine() {
        List<List<Integer>> obstacles = Collections.singletonList(Arrays.asList(5, 2));
        long attackable = Solution.queensAttack(6, obstacles.size(), 3, 3, obstacles);
        assertEquals(19, attackable);
    }

    @Test
    void testMaxObstaclesBlockingSomeDirections() {
        List<List<Integer>> obstacles = Arrays.asList(
                Arrays.asList(4, 8),
                Arrays.asList(8, 4),
                Arrays.asList(1, 4),
                Arrays.asList(7, 7),
                Arrays.asList(2, 2)
        );
        long attackable = Solution.queensAttack(8, obstacles.size(), 4, 4, obstacles);
        assertEquals(20, attackable);
    }

    @Test
    void testHugeBoardNoObstacles() {
        // Extreme boundary: must run fast, correct behavior
        long result = Solution.queensAttack(100000, 0, 50000, 50000, Collections.emptyList());

        // Expected:
        long horizontal = (50000 - 1) + (100000 - 50000);
        long vertical   = (50000 - 1) + (100000 - 50000);
        long diag1 = Math.min(100000 - 50000, 100000 - 50000); // up-right
        long diag2 = Math.min(100000 - 50000, 50000 - 1);      // up-left
        long diag3 = Math.min(50000 - 1, 100000 - 50000);      // down-right
        long diag4 = Math.min(50000 - 1, 50000 - 1);           // down-left

        long expected = horizontal + vertical + diag1 + diag2 + diag3 + diag4;

        assertEquals(expected, result);
    }

    @Test
    void testObstacleOnQueenSquare() {
        // Some HR tests incorrectly include this; your code must safely ignore it
        List<List<Integer>> obstacles = Collections.singletonList(Arrays.asList(4, 4));
        long result = Solution.queensAttack(8, 1, 4, 4, obstacles);

        // Just compute normal free board result:
        long expected =
                (4 - 1) + (8 - 4) +
                        (4 - 1) + (8 - 4) +
                        Math.min(8 - 4, 8 - 4) +
                        Math.min(8 - 4, 4 - 1) +
                        Math.min(4 - 1, 8 - 4) +
                        Math.min(4 - 1, 4 - 1);

        assertEquals(expected, result);
    }

}
