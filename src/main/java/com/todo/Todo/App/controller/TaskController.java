package com.todo.Todo.App.controller;

import com.todo.Todo.App.models.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.todo.Todo.App.services.TaskService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TaskController {
    private final TaskService _taskService;

    public TaskController(TaskService taskService) {
        this._taskService = taskService;
    }

    @GetMapping
    public String getTasks(Model model) {
        List<Task> tasks = _taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    @PostMapping
    public String createTasks(@RequestParam String title) {
        _taskService.createNewTask(title);
        return "redirect:/";
    }

    @GetMapping("/{id}/delete")
    public String deleteTask(@PathVariable Long id) {
        _taskService.deleteTask(id);
        return "redirect:/";
    }

    @GetMapping("/{id}/toggle")
    public String toggleTask(@PathVariable String id) {
        _taskService.toggleTask(Long.parseLong(id));
        return "redirect:/";
    }
}
