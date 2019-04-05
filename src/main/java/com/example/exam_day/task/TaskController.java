package com.example.exam_day.task;

import com.example.exam_day.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {
    TaskService taskService;
    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    @PostMapping("/task")
    public TaskDto saveTaskByUser(TaskDto taskDto){
        return taskService.saveUser(taskDto);
    }
    @GetMapping("/tasks/{task_id}")
    public TaskDto getTaskById(@PathVariable("task_id") Long task_id){
        return taskService.getTaskById(task_id);
    }


}
