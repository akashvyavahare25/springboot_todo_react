package com.springboot_todo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot_todo.Repository.TodoJpaRepository;
import com.springboot_todo.exception.ResourceNotFoundException;
import com.springboot_todo.model.Todo;





@Service
@Transactional
public class TodoServiceImpl implements TodoService {

	@Autowired
	private TodoJpaRepository todoJpaRepository;

	
	@Override
	public Todo createTodo(Todo todo) {
        return todoJpaRepository.save(todo);
	}

	@Override
	public Todo updateTodo(Todo todo) {
	 Optional<Todo> todoDb=this.todoJpaRepository.findById(todo.getId());
		 
		 if(todoDb.isPresent()) {
			 Todo todoUpdate =todoDb.get();
			 todoUpdate.setId(todo.getId());
			 todoUpdate.setName(todo.getName());
			 todoUpdate.setStatus(todo.getStatus());
			 todoJpaRepository.save(todoUpdate);
			 return todoUpdate;
			
		 }else {
			  throw new ResourceNotFoundException("Record not found with id : " + todo.getId());
		 }
		
	}

	
	@Override
	public List<Todo> getAllTodo() {
		return this.todoJpaRepository.findAll();
	}

	@Override
	public Todo getTodoById(long todoId) {
		 Optional<Todo> todoDb= this.todoJpaRepository.findById(todoId);
		 
		 if(todoDb.isPresent()) {
			
			return todoDb.get();
		 }else {
		
			  throw new ResourceNotFoundException("Record not found with id : " + todoId);

		 	}
	}

	@Override
	public void deletetodo(long todoId) {
		// TODO Auto-generated method stub
		
		Optional<Todo> todoDb=this.todoJpaRepository.findById(todoId);
		 
		 if(todoDb.isPresent()) {
			
			this.todoJpaRepository.delete(todoDb.get());
		 }else {
		
			  throw new ResourceNotFoundException("Record not found with id : " + todoId);

		 }
	}

}
