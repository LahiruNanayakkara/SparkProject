package com.todo.Todo.App.services;

import com.todo.Todo.App.models.Task;
import org.springframework.stereotype.Service;
import com.todo.Todo.App.repository.TaskRepository;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository _taskRepository;

    public TaskService(TaskRepository taskRepository) {
        _taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return _taskRepository.findAll();
    }

    public String createNewTask(String title) {
        Task newTask = new Task();
        newTask.title = title;
        newTask.isCompleted = false;
        _taskRepository.save(newTask);
        return title;
    }

    public void deleteTask(Long id) {
        Task task =_taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Task ID"));
        _taskRepository.delete(task);
    }

    public void toggleTask(Long id) {
        Task task = _taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Task ID"));
        task.isCompleted = !task.isCompleted;
        _taskRepository.save(task);
    }
}
