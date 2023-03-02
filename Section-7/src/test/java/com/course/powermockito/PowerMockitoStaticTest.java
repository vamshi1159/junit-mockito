package com.course.powermockito;


import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Arrays;




@PowerMockIgnore("jdk.internal.reflect.*")
@RunWith(PowerMockRunner.class)
@PrepareForTest(UtilityClass.class)
public class PowerMockitoStaticTest {

    //Speecific Runner
    //Intialise UtiltyClass
    //mock
    @Mock
    Dependency dependency;

    @InjectMocks
    SystemUnderTest systemUnderTest;
    @Test
    public void test_mockingStaticMethod(){
//        UtilityClass utilityClass =PowerMockito.mock(UtilityClass.class);
        BDDMockito.given(dependency.retrieveAllStats()).willReturn(Arrays.asList(1,2,3,4));

        PowerMockito.mockStatic(UtilityClass.class);
        BDDMockito.given(UtilityClass.staticMethod(10)).willReturn(10);
        int a = systemUnderTest.methodCallingAStaticMethod();

        Assert.assertThat(systemUnderTest.methodCallingAStaticMethod(),CoreMatchers.is(10));

        PowerMockito.verifyStatic();
        UtilityClass.staticMethod(10);
        PowerMockito.verifyStatic(Mockito.times(1));
    }
}
