package com.example.exam_day.task;

import com.example.exam_day.task.enums.TaskStatus;
import com.example.exam_day.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;
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
    @GetMapping("/user_tasks/{user_id}")
    public List<TaskDto> getAllTasksForUser(
            @PathVariable("user_id") Long user_id){
        return taskService.getAllTasksForUser(user_id);
    }
    @GetMapping("/tasks_user_status/{user_id}/{status}")
    public List<TaskDto> getAllTasksForUserAndStatus(
            @PathVariable("user_id") Long user_id,
            @PathVariable("status") TaskStatus taskStatus){
        return taskService.getAllTasksForUserAndStatus(user_id, taskStatus);
    }
    @DeleteMapping("/task/{id}")
    public TaskDto deleteTaskById(@PathVariable("id") Long id){
        return taskService.deleteTaskById(id);

    }

    @PutMapping ("/task_updateUser/{id_task}/{new_id_user}")
    public TaskDto updateTaskUser(
                @PathVariable("id_task") Long task_id,
                @PathVariable("new_id_user") Long user_id){
        return taskService.updateTaskUser(task_id,user_id);
    }

    @GetMapping("/sortedtask")
    public List<TaskDto> getSortedTask(){

        return taskService.getSortedTask();
    }


}
