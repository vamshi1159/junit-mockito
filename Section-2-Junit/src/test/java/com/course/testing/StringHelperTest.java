package com.course.testing;

import static org.junit.Assert.*;

import com.course.junit.StringHelper;
import org.junit.Test;

public class StringHelperTest {

    @Test
    public void test_Truncate_Positive(){
        //fail("not implemented");

        StringHelper helper = new StringHelper();
        assertEquals("CD",helper.truncateAInFirst2Positions("AACD"));
    }

    @Test
    public void test_FirstAndLst_Positive(){
        StringHelper helper = new StringHelper();
        assertEquals("ABAB",helper.areFirstAndLastTwoCharactersTheSame("ABAB"));
    }

    @Test
    public void test_FristAndLst_Nge(){
        StringHelper helper = new StringHelper();
        assertEquals("AB",helper.areFirstAndLastTwoCharactersTheSame("ABB"));

    }
}
