package com.code.labs.bigo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LogarithmicTimeTest {

    private LogarithmicTime logarithmicTime;

    @Test
    void binarySearch_thenSuccess(){
        logarithmicTime = new LogarithmicTime(new int[]{1,2,3,4,5,6,7,8,9});
        assertEquals(5, logarithmicTime.binarySearch(6));
    }


}