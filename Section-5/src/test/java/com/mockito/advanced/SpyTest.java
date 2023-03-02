package com.mockito.advanced;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class SpyTest {

    @Test
    public void spyList(){
        List listSpy = Mockito.spy(ArrayList.class);

        listSpy.add("Dummy");

        Mockito.verify(listSpy).add("Dummy");
        //spy is partially mocking case where if you want to use
        //you can use functions and want to stub ,can stub
    }
}
