package com.course.junit.business;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.*;


public class ListTest {

    @Test
    public void test_list(){
        List listmock = mock(List.class);
        when((listmock.size())).thenReturn(2);
        assertEquals(2,listmock.size());
        assertEquals(2,listmock.size());

    }
    @Test
    public void test_list_reuse(){
        List listmock = mock(List.class);
        when((listmock.size())).thenReturn(2).thenReturn(3);
        assertEquals(2,listmock.size());
        assertEquals(3,listmock.size());
    }

    @Test
    public void test_list_get(){
        List listmock = mock(List.class);
        when((listmock.get(1))).thenReturn(2);
        assertEquals(2,listmock.size());
        assertEquals(3,listmock.size());
    }
    @Test
    public void test_list_get_any(){
        List listmock = mock(List.class);
        when((listmock.get(anyInt()))).thenReturn(2);
        assertEquals(2,listmock.get(1));
        assertEquals(2,listmock.get(2));
    }

    @Test(expected = RuntimeException.class)
    public void test_exception(){
        List listmock = mock(List.class);
        when(listmock.get(anyInt())).thenThrow(new RuntimeException());
        listmock.get(0);
    }

    @Test(expected = RuntimeException.class)
    public void test_exception_mixed(){
        List listmock = mock(List.class);
        when(listmock.subList(anyInt(),5)).thenThrow(new RuntimeException());
        listmock.subList(5,5);
    }
}
