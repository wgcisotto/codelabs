package com.code.labs.hackerrank.implementation.QueensAttackII;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

    /*
     * Complete the 'queensAttack' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     *  3. INTEGER r_q
     *  4. INTEGER c_q
     *  5. 2D_INTEGER_ARRAY obstacles
     */

    public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
        // Write your code here
        // n -> Rows and Columns
        // k -> number of obstacles on the board
        // r_q -> row number of the queen's position
        // c_q -> column number of the queen's position
        // obstacles -> each element is an array of  integers, the row and column of an obstacle
        if(obstacles.size() != k) throw new IllegalArgumentException();

        int up = n - r_q;
        int down = n - up -1;
        int right = n - c_q;
        int left = n - right -1;

        int up_right = Math.min(up, right);
        int up_left = Math.min(up, left);
        int down_right = Math.min(down, right);
        int down_left = Math.min(down, left);

        for (List<Integer> o: obstacles){
            int or = o.get(0);
            int oc = o.get(1);

            //Same column
            if(oc == c_q){
                // up or down
                if(or > r_q) {
                    up = Math.min(up, or - r_q - 1);
                }
                if(or < r_q) {
                    down = Math.min(down, r_q - or -1);
                }
            // Same row
            } else if(or == r_q){
                if (oc > c_q){
                    right = Math.min(right, oc - c_q - 1);
                }
                if (oc < c_q){
                    left = Math.min(left, c_q - oc - 1);
                }
            } else if (Math.abs(or - r_q) == Math.abs(oc - c_q)){
                int dist = Math.abs(or - r_q) - 1;

                if (or > r_q && oc > c_q){
                    up_right = Math.min(up_right, dist);
                }

                if (or < r_q && oc > c_q) {
                    down_right = Math.min(down_right, dist);
                }

                if (or > r_q && oc < c_q) {
                    up_left = Math.min(up_left, dist);
                }

                if (or < r_q && oc < c_q) {
                    down_left = Math.min(down_left, dist);
                }
            }

        }

        return up + down + right + left + up_right + up_left + down_right + down_left;
    }

    public static void main(String[] args) {
        List<List<Integer>> obstacles = Arrays.asList(
                Arrays.asList(5, 5),
                Arrays.asList(4, 2),
                Arrays.asList(2, 3)
        );
        queensAttack(5, 3, 4, 3, obstacles);

        queensAttack(1, 0, 1, 1, Collections.emptyList());

        queensAttack(4, 0, 4, 4, Collections.emptyList());
    }


}
