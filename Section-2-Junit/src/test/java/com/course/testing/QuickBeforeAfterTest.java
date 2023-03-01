package com.course.testing;

import org.junit.*;

public class QuickBeforeAfterTest {

    @BeforeClass
    public static void beforeClass(){
        System.out.println("beforeclass");
    }
    @Before
    public void setup(){
        System.out.println("setup");
    }

    @Test
    public void test(){
        System.out.println("test1 executed");
    }

   @Test
    public void test1(){
       System.out.println("test2 executed");
    }

    @After
    public void end(){
        System.out.println("finished");
    }

    @AfterClass
    public  static void afterClass(){
        System.out.println("after class");
    }
}
