package com.springboot_todo.Service;

import java.util.List;

import com.springboot_todo.model.Todo;


public interface TodoService {

	Todo createTodo(Todo todo);
	
	Todo updateTodo(Todo todo);
	
	List<Todo> getAllTodo();
	
	Todo getTodoById(long todoId);
	
	void deletetodo(long id);
	
}
