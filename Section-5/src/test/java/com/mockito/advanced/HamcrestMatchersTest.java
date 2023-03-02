package com.mockito.advanced;






import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.BDDMockito.*;
import static org.mockito.Matchers.*;
import static org.hamcrest.Matchers.*;


import java.util.Arrays;
import java.util.List;

public class HamcrestMatchersTest {

    @Test
    public void test(){
        List<Integer> scores = Arrays.asList(1,2,3,4,5);

        //scores has 4 items
        assertThat(scores, hasSize(5));
        assertThat(scores,hasItems(2,3,4));
        assertThat(scores,everyItem(lessThan(6)));
        assertThat(scores,everyItem(greaterThan(0)));

        //String

        assertThat("",isEmptyString());
        assertThat(null,isEmptyOrNullString());

        //Arrays

        Integer[] marks = {1,2,3};

        assertThat(marks,arrayWithSize(3));
        assertThat(marks,arrayContaining(1,2,3));
        assertThat(marks,arrayContainingInAnyOrder(1,3,2));
    }
}
