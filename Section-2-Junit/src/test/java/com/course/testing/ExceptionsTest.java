package com.course.testing;

import org.junit.Test;

import static  org.junit.Assert.*;

public class ExceptionsTest {

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void AccessingOut(){
        int[] numbers = {1,2,3,4};
        assertEquals(4,numbers[5]);
    }

}
