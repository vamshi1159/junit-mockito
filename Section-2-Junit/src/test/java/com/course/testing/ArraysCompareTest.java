package com.course.testing;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Arrays;

public class ArraysCompareTest {

    //Arrasy.sort

    @Test
    public void testSort_positive(){
        int[] number = {12,3,4,1};
        int[] expected = {1,3,4,12};
        Arrays.sort(number);
        assertArrayEquals(expected,number);
    }

    @Test(expected = NullPointerException.class)
    public void testSort_Exception(){
        int[] number = null;
        int[] expected = {1,2,4,12};
        Arrays.sort(number);
        assertArrayEquals(expected,number);
    }
}
