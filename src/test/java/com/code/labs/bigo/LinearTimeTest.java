package com.code.labs.bigo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinearTimeTest {

    private LinearTime linearTime;

    @Test
    void getSquares_thenSuccess(){
        linearTime = new LinearTime(new int[]{1,2,3,4,5,6,7,8,9});
        assertEquals(1, linearTime.getSquares()[0]);
        assertEquals(16, linearTime.getSquares()[3]);
        assertEquals(81, linearTime.getSquares()[8]);

    }

    @Test
    void getSum_thenSuccess(){
        linearTime = new LinearTime(new int[]{1,2});
        assertEquals(3, linearTime.getSum());
    }

    @Test
    void getStreamSum_thenSuccess(){
        linearTime = new LinearTime(new int[]{5,9});
        assertEquals(14, linearTime.getStreamSum());
    }

}