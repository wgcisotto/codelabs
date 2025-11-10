package com.code.labs.hackerrank.warmup.Staircase;

import org.junit.jupiter.api.*;
import java.io.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private PrintStream originalOut;

    @BeforeEach
    void setUp() {
        // Backup the original System.out and redirect output
        originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        // Restore System.out
        System.setOut(originalOut);
    }

    @Test
    void testStaircaseWithN4() {
        Solution.staircase(4);
        String expected =
                "   #\n" +
                "  ##\n" +
                " ###\n" +
                "####\n";
        assertEquals(expected, outputStream.toString());
    }

    @Test
    void testStaircaseWithN1() {
        Solution.staircase(1);
        String expected = "#\n";
        assertEquals(expected, outputStream.toString());
    }

    @Test
    void testStaircaseWithN3() {
        Solution.staircase(3);
        String expected =
                "  #\n" +
                " ##\n" +
                "###\n";
        assertEquals(expected, outputStream.toString());
    }

    @Test
    void testStaircaseWithN5() {
        Solution.staircase(5);
        String expected =
                "    #\n" +
                "   ##\n" +
                "  ###\n" +
                " ####\n" +
                "#####\n";
        assertEquals(expected, outputStream.toString());
    }

}