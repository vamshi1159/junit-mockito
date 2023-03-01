package com.course.testing;

import org.junit.Test;

import java.util.Arrays;

public class PerformanceTest {
    @Test(timeout = 10)
    public void testPerformace(){
        int arr[] = {1,2,3};
        for(int i=1;i<=100000;i++){
            arr[0]=i;
            Arrays.sort(arr);
        }

    }
}
