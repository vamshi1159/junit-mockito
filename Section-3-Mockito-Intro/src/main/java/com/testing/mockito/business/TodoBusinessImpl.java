package com.testing.mockito.business;

import com.testing.mockito.data.api.TodoService;

import java.util.ArrayList;
import java.util.List;


//TodoBusinessImple SUT(system under Test)
//TodoService dependency
public class TodoBusinessImpl {
	private TodoService todoService;

	 TodoBusinessImpl(TodoService todoService) {
		this.todoService = todoService;
	}

	public List<String> retrieveTodosRelatedToSpring(String user) {
		List<String> filteredTodos = new ArrayList<String>();
		List<String> allTodos = todoService.retrieveTodos(user);
		for (String todo : allTodos) {
			if (todo.contains("Spring")) {
				filteredTodos.add(todo);
			}
		}
		return filteredTodos;
	}
}