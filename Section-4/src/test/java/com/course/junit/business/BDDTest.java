package com.course.junit.business;

import com.course.junit.data.api.TodoService;

import static  org.junit.Assert.*;
import static org.mockito.BDDMockito.*;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.Arrays;
import java.util.List;


public class BDDTest {

    @Test
    public void testRetrieveTodosRelated_usingBDD(){
        //Given
        TodoService todoService = mock(TodoService.class);

        given(todoService.retrieveTodos("dummy")).willReturn(Arrays.asList("Spring","Spring MVC"));

        TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoService);

        //when
        int getSize = todoBusiness.retrieveTodosRelatedToSpring("dummy").size();

        //then
        assertThat(getSize, is(2));
    }

    @Test
    public void testMockListGetUsingBDD(){
        //given
        List<String> listMock= mock(List.class);
        given(listMock.get(anyInt())).willReturn("inMinutes");

        //when
        String firstElement = listMock.get(0);

        //then
        assertThat(firstElement,is("inMinutes"));
    }

    @Test
    public void testDeleteNotReletedToSpring(){
        //given
        TodoService todoService = mock(TodoService.class);
        given(todoService.retrieveTodos(anyString())).willReturn(Arrays.asList("Spring","Spring MVC","mvc"));
        TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoService);

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
        TodoService todoService = mock(TodoService.class);
        given(todoService.retrieveTodos(anyString())).willReturn(Arrays.asList("Spring","Spring MVC","mvc"));
        TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoService);

        //when
        todoBusiness.deleteTodosNotRelatedToSpring("user");

        //then
        then(todoService).should().deleteToDOs("mvc");


        then(todoService).should(never()).deleteToDOs("Spring");

        then(todoService).should(times(0)).deleteToDOs("Spring MVC");
    }

    @Test
    public void testDeleteNotReletedToSpring_argumentCapture(){

        //Declare Arguement Captor
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        //Define Argument captor on specific method call

        //caprue the agurment

        //given
        TodoService todoService = mock(TodoService.class);
        given(todoService.retrieveTodos(anyString())).willReturn(Arrays.asList("Spring","Spring MVC","mvc"));
        TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoService);

        //when
        todoBusiness.deleteTodosNotRelatedToSpring("user");

        //then
        then(todoService).should(times(2)).deleteToDOs(stringArgumentCaptor.capture());
        assertThat(stringArgumentCaptor.getAllValues().size(),is(2));


    }
}
