package com.testing.mockito.business;

import com.testing.mockito.data.api.TodoService;
import com.testing.mockito.data.api.TodoServiceStub;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

import java.util.Arrays;

public class TodoBusinessImplMockTest {
    @Test
    public void test_usingMock_1(){

        TodoService mockTodoServie = Mockito.mock(TodoService.class);
        Mockito.stub(mockTodoServie.retrieveTodos(Matchers.any())).toReturn(Arrays.asList("Learn Spring","Learn Spring mvc"));
        TodoBusinessImpl todoBusiness = new TodoBusinessImpl(mockTodoServie);
        Assert.assertEquals(2,todoBusiness.retrieveTodosRelatedToSpring("bc").size());

    }

    @Test
    public void test_usingMock_2(){

        TodoService mockTodoServie = Mockito.mock(TodoService.class);
        Mockito.when(mockTodoServie.retrieveTodos(Matchers.any())).thenReturn(Arrays.asList("Learn spring","Learn spring mvc"));
        TodoBusinessImpl todoBusiness = new TodoBusinessImpl(mockTodoServie);
        Assert.assertEquals(0,todoBusiness.retrieveTodosRelatedToSpring("bc").size());

    }
}
