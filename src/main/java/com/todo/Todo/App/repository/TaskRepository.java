package com.todo.Todo.App.repository;

import com.todo.Todo.App.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
