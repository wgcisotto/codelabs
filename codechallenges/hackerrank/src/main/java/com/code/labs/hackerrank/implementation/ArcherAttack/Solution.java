package com.code.labs.hackerrank.implementation.ArcherAttack;

import java.util.List;

public class Solution {

    public static int archerAttack(int n, int k, int r_a, int c_a, int L, List<List<Integer>> obstacles){
        // Write your code here
        // n -> Rows and Columns
        // k -> number of obstacles on the board
        // r_a -> row number of the archer's position
        // c_a -> column number of the archer's position
        // L -> maximum shooting range
        // obstacles -> each element is an array of integers, the row and column of an obstacle

        int up = n - r_a;
        int down = n - up - 1;
        int right = n - c_a;
        int left = n - right -1;

        int upRight = Math.min(up, right);
        int downRight = Math.min(down, right);
        int upLeft = Math.min(up, left);
        int downLeft = Math.min(down, left);

        for (List<Integer> o: obstacles) {
            int r_o = o.get(0);
            int c_o = o.get(1);
            if (c_o == c_a) {
                if(r_o > r_a) {
                    up = Math.min(up, r_o - r_a -1);
                } else if (r_o < r_a) {
                    down = Math.min(down, r_a - r_o -1);
                }
            }
            if (r_o == r_a) {
                if (c_o > c_a) {
                    right = Math.min(right, c_o - c_a -1);
                } else if (c_o < c_a) {
                    left = Math.min(left, c_a - c_o -1);
                }
            }
            if (Math.abs(c_o - c_a) == Math.abs(r_o - r_a)){
                int dist = Math.abs(c_o - c_a) -1;
                if(c_o > c_a && r_o > r_a) {
                    upRight = Math.min(upRight, dist);
                }
                if(c_o > c_a && r_o < r_a) {
                    downRight = Math.min(downRight, dist);
                }
                if(c_o < c_a && r_o > r_a) {
                    upLeft = Math.min(upLeft, dist);
                }
                if(c_o < c_a && r_o < r_a) {
                    downLeft = Math.min(downLeft, dist);
                }
            }
        }
        return Math.min(up, L) + Math.min(down, L) + Math.min(right, L) + Math.min(left, L)
                + Math.min(upRight, L) + Math.min(downRight, L) + Math.min(upLeft, L) + Math.min(downLeft, L);
    }

}
 // 0 0 0 0 0 0 0 -
 // - 0 0 * 0 0 - 0
 // 0 - 0 - 0 - 0 0
 // 0 0 - - - 0 0 0
 // - - - x - - * 0
 // 0 0 - - - 0 0 0
 // 0 * 0 - 0 - 0 0
 // 0 0 0 - 0 0 - 0

// - 0 - 0 -
// 0 - - - 0
// - - x - -
// 0 - - - 0
// 1 0 - 0 -