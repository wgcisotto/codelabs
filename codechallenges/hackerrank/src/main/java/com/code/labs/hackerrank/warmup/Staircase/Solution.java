package com.code.labs.hackerrank.warmup.Staircase;

public class Solution {

    public static void staircase(int n) {
        // Write your code here
        int spaces = n-1;
        int stair = 1;
        for(int x = 0; x < n; x++){
            for(int i = 0; i < spaces; i++){
                System.out.print(" ");
            }
            for(int y = 0; y < stair; y++){
                System.out.print("#");
            }
            System.out.println();
            stair++;
            spaces--;
        }
    }

    public static void staircase2(int n) {
        for (int i = 1; i <= n; i++) {
            int spaces = n - i;
            System.out.println(" ".repeat(spaces) + "#".repeat(i));
        }
    }

    public static void main(String[] args) {
        staircase2(6);
    }
}