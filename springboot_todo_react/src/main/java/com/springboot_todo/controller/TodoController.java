package com.springboot_todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot_todo.Service.TodoService;
import com.springboot_todo.model.Todo;



@RestController
public class TodoController {
	
	  @Autowired
      private TodoService todoService;
	  
	   @GetMapping("/todos")
	   public ResponseEntity<List<Todo>> getAllTodo(){
			
			return ResponseEntity.ok().body(todoService.getAllTodo());
		}
	   
	   
		@GetMapping("/todos/{id}")
		public ResponseEntity <Todo> getTodoById(@PathVariable Long id){
			
			return ResponseEntity.ok().body(todoService.getTodoById(id));
		}
		
		@PostMapping("/todos")
		public ResponseEntity<Todo> createTodo(@RequestBody Todo todo){
			
			return ResponseEntity.ok().body(this.todoService.createTodo(todo));
		}
		
		@PutMapping("/todos/{id}")
	    public ResponseEntity<Todo> updateTodo(@PathVariable Long id, @RequestBody Todo todo){
			
			todo.setId(id);
			return ResponseEntity.ok().body(this.todoService.updateTodo(todo));
		}
		
		@DeleteMapping("/todos/{id}")
		public HttpStatus deleteTodo(@PathVariable long id){
			this.todoService.deletetodo(id);
			return HttpStatus.OK;
			
		}
	  

}
