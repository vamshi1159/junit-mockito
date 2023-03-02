package com.mockito.advanced;

import com.mockito.advanced.api.TodoService;
import com.mockito.advanced.business.TodoBusinessImpl;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.*;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class MockitoRuleTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
    @Mock
    TodoService todoService;

    @InjectMocks
    TodoBusinessImpl todoBusiness;

    //Declare Arguement Captor
    ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);

    @Captor
    ArgumentCaptor<String> captor;

    @Test
    public void testRetrieveTodosRelated_usingBDD(){
        //Given


        given(todoService.retrieveTodos("dummy")).willReturn(Arrays.asList("Spring","Spring MVC"));

        //when
        int getSize = todoBusiness.retrieveTodosRelatedToSpring("dummy").size();

        //then
        assertThat(getSize, is(2));
    }


    @Test
    public void testDeleteNotReletedToSpring(){
        //given
        given(todoService.retrieveTodos(anyString())).willReturn(Arrays.asList("Spring","Spring MVC","mvc"));
        //when
        todoBusiness.deleteTodosNotRelatedToSpring("user");

        //then
        verify(todoService,times(1)).deleteToDOs("mvc");


        verify(todoService,never()).deleteToDOs("Spring");

        verify(todoService,never()).deleteToDOs("Spring MVC");
    }

    @Test
    public void testDeleteNotReletedToSpring_Then(){
        //given

        given(todoService.retrieveTodos(anyString())).willReturn(Arrays.asList("Spring","Spring MVC","mvc"));

        //when
        todoBusiness.deleteTodosNotRelatedToSpring("user");

        //then
        then(todoService).should().deleteToDOs("mvc");


        then(todoService).should(never()).deleteToDOs("Spring");

        then(todoService).should(times(0)).deleteToDOs("Spring MVC");
    }

    @Test
    public void testDeleteNotReletedToSpring_argumentCapture(){

        //Define Argument captor on specific method call

        //caprue the agurment

        //given

        given(todoService.retrieveTodos(anyString())).willReturn(Arrays.asList("Spring","Spring MVC","mvc"));

        //when
        todoBusiness.deleteTodosNotRelatedToSpring("user");

        //then
        then(todoService).should(times(1)).deleteToDOs(stringArgumentCaptor.capture());
        assertThat(stringArgumentCaptor.getAllValues().size(),is(1));


    }

    @Test
    public void testDeleteNotReletedToSpring_argumentCapture_captor(){

        //Define Argument captor on specific method call

        //caprue the agurment

        //given

        given(todoService.retrieveTodos(anyString())).willReturn(Arrays.asList("Spring","Spring MVC","mvc"));

        //when
        todoBusiness.deleteTodosNotRelatedToSpring("user");

        //then
        then(todoService).should(times(1)).deleteToDOs(captor.capture());
        assertThat(captor.getAllValues().size(),is(1));


    }
}
