package com.testing.mockito.business;


import com.testing.mockito.data.api.TodoServiceStub;
import com.testing.mockito.data.api.TodoService;
import junit.framework.Assert;

public class TodoBusinessImplStubTest {

    @org.junit.Test
    public void test(){
        TodoService todoServiceStub = new TodoServiceStub();
        TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoServiceStub);
        Assert.assertEquals(2,todoBusiness.retrieveTodosRelatedToSpring("abc").size());

    }
}
