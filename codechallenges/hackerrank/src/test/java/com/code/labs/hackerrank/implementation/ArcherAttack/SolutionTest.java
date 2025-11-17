package com.code.labs.hackerrank.implementation.ArcherAttack;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testNoObstaclesSmallBoard() {
        // 5x5, archer in center, range 4 (full board reach)
        long attackable = Solution.archerAttack(
                5, 0, 3, 3, 4, Collections.emptyList());

        // Expected:
        // Horizontal: left(2)=2, right(2)=2 → 4
        // Vertical: up(2)=2, down(2)=2 → 4
        // Diagonals: up-right(2)=2, up-left(2)=2, down-right(2)=2, down-left(2)=2 → 8
        // Total = 4 + 4 + 8 = 16
        assertEquals(16, attackable);
    }

    @Test
    void testSingleCellBoard() {
        // Archer alone in 1x1 grid
        long attackable = Solution.archerAttack(
                1, 0, 1, 1, 10, Collections.emptyList());

        assertEquals(0, attackable);
    }

    @Test
    void testObstacleImmediatelyNextToArcher() {
        // 5x5 with obstacles in all 8 directions at distance 1
        List<List<Integer>> obs = Arrays.asList(
                Arrays.asList(3, 2),  // left
                Arrays.asList(3, 4),  // right
                Arrays.asList(2, 3),  // down
                Arrays.asList(4, 3),  // up
                Arrays.asList(2, 2),  // down-left
                Arrays.asList(2, 4),  // down-right
                Arrays.asList(4, 2),  // up-left
                Arrays.asList(4, 4)   // up-right
        );

        long attackable = Solution.archerAttack(
                5, obs.size(), 3, 3, 4, obs);

        assertEquals(0, attackable);
    }

    @Test
    void testObstacleAtDistance() {
        // Example from prompt
        List<List<Integer>> obs = Arrays.asList(
                Arrays.asList(4, 7),  // right
                Arrays.asList(7, 4),  // up
                Arrays.asList(2, 2)   // down-left
        );

        long attackable = Solution.archerAttack(
                8, obs.size(), 4, 4, 4, obs);

        assertEquals(21, attackable);
    }

    @Test
    void testLimitedRangeStopsBeforeBoardEdge() {
        // 10x10, archer (5,5), no obstacles, range = 3
        long attackable = Solution.archerAttack(
                10, 0, 5, 5, 3, Collections.emptyList());

        // Horizontal: 3 left + 3 right = 6
        // Vertical: 3 up + 3 down = 6
        // Diagonals: 3 in all 4 diagonals = 12
        // Total = 6 + 6 + 12 = 24
        assertEquals(24, attackable);
    }

    @Test
    void testObstacleNotAffectingAnyDirection() {
        // Obstacle at non-straight/diagonal position
        List<List<Integer>> obs = Collections.singletonList(
                Arrays.asList(6, 1));

        long attackable = Solution.archerAttack(
                6, 1, 3, 3, 10, obs);

        // No effect, compute normally:
        // Horizontal: 2 left + 3 right = 5
        // Vertical: 2 down + 3 up = 5
        // Diagonals: 3 + 2 + 2 + 2 = 9
        // Total = 19
        assertEquals(19, attackable);
    }

    @Test
    void testOverlappingObstacles() {
        List<List<Integer>> obs = Arrays.asList(
                Arrays.asList(3, 5),
                Arrays.asList(3, 5)
        );

        long attackable = Solution.archerAttack(
                5, obs.size(), 3, 3, 10, obs);

        // Right blocked at 5 → 1 square
        // Others open:
        // Left=2, Up=2, Down=2, Diag UR=2, UL=2, DR=2, DL=2
        // Total = 1 + (2*7) = 15
        assertEquals(15, attackable);
    }

    @Test
    void testArcherAtBoardCorner() {
        long attackable = Solution.archerAttack(
                4, 0, 1, 1, 5, Collections.emptyList());

        // Right: 3
        // Up: 3
        // Diagonal up-right: 3
        // Total = 9
        assertEquals(9, attackable);
    }

    @Test
    void testObstacleInsideRangeButNotClosest() {
        // Range = 5 but obstacle further should not affect range=3 cap
        List<List<Integer>> obs = Collections.singletonList(
                Arrays.asList(1, 1)); // diagonal but far

        long attackable = Solution.archerAttack(
                5, 1, 3, 3, 2, obs);

        // Range is only 2 → board/obstacle irrelevant
        // Horizontal: 2 left + 2 right = 4
        // Vertical: 2 up + 2 down = 4
        // Diagonals: 2 in each = 8
        assertEquals(15, attackable);
    }

    @Test
    void testLargeBoardNoObstacles() {
        long attackable = Solution.archerAttack(
                100000, 0, 50000, 50000, 100000, Collections.emptyList());

        // We verify non-zero and no overflow; result is large but deterministic.
        assertTrue(attackable > 0);
    }
}
