package com.springboot_todo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot_todo.model.Todo;

@Repository
public interface TodoJpaRepository  extends JpaRepository<Todo,Long>{

}
