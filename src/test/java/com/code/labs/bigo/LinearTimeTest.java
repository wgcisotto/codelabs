package com.code.labs.bigo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LinearTimeTest {

    private LinearTime linearTime;

    @Test
    void getSquares_thenSuccess(){
        linearTime = new LinearTime(new int[]{1,2,3,4,5,6,7,8,9});
        Assertions.assertEquals(1, linearTime.getSquares()[0]);
        Assertions.assertEquals(16, linearTime.getSquares()[3]);
        Assertions.assertEquals(81, linearTime.getSquares()[8]);

    }

    @Test
    void getSum_thenSuccess(){
        linearTime = new LinearTime(new int[]{1,2});
        Assertions.assertEquals(3, linearTime.getSum());
    }

    @Test
    void getStreamSum_thenSuccess(){
        linearTime = new LinearTime(new int[]{5,9});
        Assertions.assertEquals(14, linearTime.getStreamSum());
    }

}